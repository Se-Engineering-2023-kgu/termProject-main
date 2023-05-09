package rest.order.reservation.Model.DTO.AppUser;

import rest.order.reservation.Model.User.AppUser;

public record AppUserDTO(

        Long uid,
        String loginId,
        String loginPwd,
        String name
//        String phoneNumber,
//        String email,
//        UserClass userType
) {
    public static AppUserDTO form(AppUser appUser) {
        AppUserDTO user = new AppUserDTO(
                appUser.getUid(),
                appUser.getLoginId(),
                appUser.getLoginPwd(),
                appUser.getName()
//                appUser.getUserType()
        );
        return user;
    }

}
