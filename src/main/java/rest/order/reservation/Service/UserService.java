package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.AppUserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final AppUserRepo AppUserRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(AppUserRepo appUserRepository, BCryptPasswordEncoder passwordEncoder) {
        this.AppUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public Long addUser(UserRegistForm request) {
        AppUser user = new AppUser(
                null,
                request.loginId(),
                request.loginPwd(passwordEncoder.encode(request.loginPwd())), // loginPWD를 암호화하여 적용
                request.name(),
                request.userType(),
                request.phoneNumber(),
                request.email());
        AppUserRepository.save(user);
        return user.getUid();
    }

    public AppUserDTO findUser(Long id) {
        AppUser appUser = AppUserRepository.findById(id).get();

        AppUserDTO appUserDTO = AppUserDTO.form(appUser);

        return appUserDTO;

    }

    @Transactional
    public void deleteUser(Long id) {
        AppUser customer = AppUserRepository.findById(id).get();
        AppUserRepository.delete(customer);
    }

    @Transactional
    public void modify(Long id, AppUserDTO update) { // 이거 바꿔야 할 수도
        AppUser user = AppUserRepository.findById(id).get();
        user.chageUserInfo(update.loginPwd(), update.phonNumber(), update.email());
    }

    // login Check
    public AppUserDTO loginCheck(String loginId, String loginPwd) {
        Optional<AppUser> appUser = AppUserRepository.findByLoginId(loginId);

        if (appUser.isPresent())
            if (appUser.get().getLoginPwd().equals(loginPwd)) {
                AppUserDTO appUserDTO = AppUserDTO.form(appUser.get());
                return appUserDTO;
            }
        return null;
    }

    // user load 서비스 부분

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = AppUserRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(appUser.getUserType().name()));

        return toUserDetails(appUser);
    }

    private UserDetails toUserDetails(AppUser appUser) {
        return User.builder()
                .username(appUser.getLoginId())
                .password(appUser.getLoginPwd())
                .authorities(new SimpleGrantedAuthority(appUser.getUserType().toString()))
                .build();
    }

}
