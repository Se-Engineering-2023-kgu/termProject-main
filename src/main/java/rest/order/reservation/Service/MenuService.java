package rest.order.reservation.Service;

import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;

@Service
public class MenuService {
    
    private Menu menu;

    public MenuService(Menu menu) {
        this.menu = menu;
    }
    
    public String menuName() {
        return "WelcomeMenu";
        
    }
}
