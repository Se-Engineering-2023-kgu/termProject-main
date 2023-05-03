package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Repository.MenuRepo;

@Service
public class MenuService {

   private Menu menuClass;
   private MenuRepo menuRepository;

    @Autowired
    public MenuService(Menu menu, MenuRepo menuRepo) {
        this.menuClass = menu;
        this.menuRepository = menuRepo;
    }

    public MenuService() {
        
    }

    // public int MenuService(final Menu menu) {
        
    //     //this.price = menu.price;
    //     //return price;

    //     return menu;
    // }

    public String menuName() {
        return "WelcomeMenu";
    }

    public void addMenu(Menu menuClass) {

        menuRepository.save(menuClass); // save가 insert 가 될 수도 있고요 update 가 될 수 있어요 
    }

    
}
