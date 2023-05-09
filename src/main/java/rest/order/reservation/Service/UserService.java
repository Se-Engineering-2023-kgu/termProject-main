package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.AppUserRepo;

import java.util.Optional;

@Service
public class UserService {

    private final AppUserRepo AppUserRepository;

    public UserService(AppUserRepo appUserRepository) {
        AppUserRepository = appUserRepository;
    }

    // 회원이 존재하는지 확인
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
