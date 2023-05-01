package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Repository.MenuRepo;

@Service
public class MenuService {

    private final Menu menu;
    private final MenuRepo menuRepo;
    private int price;

    @Autowired
    public MenuService(Menu menu, MenuRepo menuRepo) {
        this.menu = menu;
        this.menuRepo = menuRepo;
    }

    public Menu() {
        
    }

    public int MenuService(Menu menu) {
        this.price = menu.price;
        return price;
    }

    public String menuName() {
        return "WelcomeMenu";
    }

    public void addMenu() {
        // mService.save() save가 insert 가 될 수도 있고요 update 가 될 수 있어요 
    }

    
}
