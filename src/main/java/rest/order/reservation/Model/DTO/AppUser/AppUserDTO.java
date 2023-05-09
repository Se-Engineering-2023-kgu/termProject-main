package rest.order.reservation.Model.DTO.AppUser;

import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.User.AppUser;

public record AppUserDTO(

        Long uid,
        String loginId,
        String loginPwd,
        String name,
        UserClass userType,
        String phonNumber,
        String email
) {
    public static AppUserDTO form(AppUser appUser) {
        AppUserDTO user = new AppUserDTO(
                appUser.getUid(),
                appUser.getLoginId(),
                appUser.getLoginPwd(),
                appUser.getName(),
                appUser.getUserType(),
                appUser.getPhoneNumber(),
                appUser.getEmail()
        );

        return user;
    }

}
