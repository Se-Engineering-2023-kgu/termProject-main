package rest.order.reservation.Model.DTO;


import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.Menu;


public record MenuDTO (
    Long mid,
    String name,
    String intro,
    Long price,
    MenuType type

){
    public static MenuDTO from(Menu menu) {
        MenuDTO menuDTO = new MenuDTO(
                                menu.getMid(), 
                                menu.getName(), 
                                menu.getIntro(), 
                                menu.getPrice(), 
                                menu.getType()
                            );    
        return menuDTO;
    }

}


