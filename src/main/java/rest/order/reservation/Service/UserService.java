package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.AppUserRepo;

import java.util.Optional;

@Service
public class UserService {

    private final AppUserRepo AppUserRepository;

    public UserService(AppUserRepo appUserRepository) {
        AppUserRepository = appUserRepository;
    }

    // 회원가입
    public Long addUser(UserRegistForm request) {
        AppUser user = new AppUser(
                null,
                request.loginId(),
                request.loginPwd(),
                request.name(),
                request.userType(),
                request.phoneNumber(),
                request.email()
        );
        AppUserRepository.save(user);
        return user.getUid();
    }


    public AppUserDTO findUser(Long id) {
        AppUser appUser = 
        AppUserRepository.findById(id).get();

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


}
