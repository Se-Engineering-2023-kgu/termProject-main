package rest.order.reservation.Model.DTO.AppUser;

import rest.order.reservation.DefineEnum.UserClass;


public record AppUserRegistDTO(
        Long id,
        String phoneNumber,
        String email,
        UserClass userType,
        String loginId,
        String loginPwd,
        String name

) {

}
