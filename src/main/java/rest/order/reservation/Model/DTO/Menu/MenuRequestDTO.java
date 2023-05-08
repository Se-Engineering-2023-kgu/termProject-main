package rest.order.reservation.Model.DTO.Menu;

import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.Menu;

public record MenuRequestDTO(
    String name,
    String intro,
    Long price,
    MenuType type
) {
    public static MenuRequestDTO from(Menu menu) {
        MenuRequestDTO menuRequestDTO = new MenuRequestDTO(menu.getName(),
                                                        menu.getIntro(), 
                                                        menu.getPrice(), 
                                                        menu.getType()
                                                        );

        return menuRequestDTO;
        
    }

}
