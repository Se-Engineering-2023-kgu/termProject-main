package rest.order.reservation.Model.DTO.AppUser;

import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.User.AppUser;

public record AppUserDTO(

        Long uid,
        String loginId,
        //String loginPwd,
        String name,
        UserClass userType,
        String phonNumber,
        String email
) {
    public static AppUserDTO form(AppUser appUser) {
        AppUserDTO user = new AppUserDTO(
                appUser.getUid(),
                appUser.getLoginId(),
                // appUser.getLoginPwd(),
                appUser.getName(),
                appUser.getUserType(),
                appUser.getPhoneNumber(),
                appUser.getEmail()
        );
//ㅇㅇㅇㅇㅇㅇ
/*
 * 우리 비밀번호 DTO로 받지 말아요.....
 * DTO를 유저로 변환할 필요가 있으면 uid 통해 findbyid 해서 받아요..... 
 */
        return user;
    }

}
