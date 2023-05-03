package rest.order.reservation.Model.DTO;

import rest.order.reservation.DefineEnum.MenuType;


public record MenuDTO (
    String name,
    String intro,
    Long price,
    MenuType type

){



}


