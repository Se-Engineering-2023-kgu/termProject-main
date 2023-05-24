package rest.order.reservation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.AppUserSearch;
import rest.order.reservation.Repository.User.AppUserRepo;

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

    public List<AppUser> findAllUser(AppUserSearch search) {
        return AppUserRepository.findAll(search);
    }

    @Transactional
    public void deleteUser(Long id) {
        AppUser customer = AppUserRepository.findById(id).get();
        AppUserRepository.delete(customer);
    }
/*
 * 찾았다 
 */
    @Transactional
    public void modify(Long id, AppUserDTO update, String encodedPW) { // 이거 바꿔야 할 수도
        AppUser user = AppUserRepository.findById(id).get();
        // PW는 컨트롤러에서 PW encoder 바로 써서 암호화된 값으로 집어넣어 주세요. 
        // 근데 이 메소드 쓰는데 없는거 같더라 
        // 맞나? 
        user.chageUserInfo(encodedPW, update.phonNumber(), update.email());

    }

    // login Check
    // 아무래도 이 부분은 springSecurity에 의해 덮어씌워진 듯 함
    public AppUserDTO loginCheck(String loginId, String loginPwd) {
        Optional<AppUser> appUser = AppUserRepository.findByLoginId(loginId);

        if (appUser.isPresent())
            if (appUser.get().getLoginPwd().equals(passwordEncoder.encode(loginPwd))) {
                AppUserDTO appUserDTO = AppUserDTO.form(appUser.get());

                System.out.println("login Success? ");
                return appUserDTO;
            }
        return null;
    }

    // user load 서비스 부분

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = AppUserRepository.findByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(appUser.getUserType().name()));

        return appUser;
    }

    // loadUserByUsername 이 UserDetails 리턴하던 시절의 코드, 혹시 모르니 남김 
    private UserDetails toUserDetails(AppUser appUser) {
        return User.builder()
                .username(appUser.getLoginId())
                .password(appUser.getLoginPwd())
                .authorities(new SimpleGrantedAuthority(appUser.getUserType().toString()))
                .build();
    }

    
    // additional information to get userinfo and role

    public AppUserDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserDetails)) {
            return null;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        // Fetch the user from the repository based on the username
        Optional<AppUser> optionalUser = AppUserRepository.findByLoginId(username);
        if (optionalUser.isPresent()) {
            AppUser appUser = optionalUser.get();
            return AppUserDTO.form(appUser);
        }

        return null;
    }

    public boolean isAdminUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }

    public AppUserDTO getPrincipalToUserDTO(Authentication authentication) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        System.out.println(appUser);
        AppUserDTO appUserDTO =  AppUserDTO.form(appUser);

        //user appUserDTO printing
        System.out.println("working Appuser DTO");
        System.out.println(appUserDTO);

        return appUserDTO;
    }

}
