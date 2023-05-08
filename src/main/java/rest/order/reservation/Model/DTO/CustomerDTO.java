package rest.order.reservation.Model.DTO;

import rest.order.reservation.DefineEnum.UserClass;

public record CustomerDTO(
    Long uid, 
    String name,
    String phoneNumber,
    String email,
    UserClass userType


) {

} 
