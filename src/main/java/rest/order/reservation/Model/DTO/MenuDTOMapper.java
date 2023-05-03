package rest.order.reservation.Model.DTO;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;

@Service
public class MenuDTOMapper implements Function<Menu, MenuDTO>{

    @Override
    public MenuDTO apply(Menu menu) {
        // TODO Auto-generated method stub
        return new MenuDTO(
            menu.getName(),
            menu.getIntro(), 
            menu.getPrice(), 
            menu.getType()
        );
    }
    
}
