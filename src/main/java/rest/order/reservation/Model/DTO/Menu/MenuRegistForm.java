package rest.order.reservation.Model.DTO.Menu;

import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.Menu;

public record MenuRegistForm (
    String name,
    String intro,
    Long price,
    MenuType type
){
    public static Menu form(MenuRegistForm menuRegistForm) {
        Menu menu = new Menu(
            menuRegistForm.name ,
            menuRegistForm.intro ,
            menuRegistForm.price, 
            menuRegistForm.type
            );
        
        return menu;
        
    }
}
    