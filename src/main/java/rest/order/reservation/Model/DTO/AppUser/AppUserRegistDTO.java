package rest.order.reservation.Model.DTO.AppUser;

import org.springframework.stereotype.Service;

import rest.order.reservation.DefineEnum.UserClass;


public record AppUserRegistDTO(
    String phoneNumber,
    String email,
    UserClass userType,
    String loginId,
    String loginPwd,
    String name

) {

}
