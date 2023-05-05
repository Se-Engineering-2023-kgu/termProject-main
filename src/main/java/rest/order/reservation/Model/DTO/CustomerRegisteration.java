package rest.order.reservation.Model.DTO;

import org.springframework.stereotype.Service;

import rest.order.reservation.DefineEnum.UserClass;


public record CustomerRegisteration(
    String phoneNumber,
    String email,
    UserClass userType,
    String loginId,
    String loginPwd,
    String name

) {

}
