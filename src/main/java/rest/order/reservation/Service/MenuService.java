package rest.order.reservation.Service;

import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Repository.MenuRepo;

@Service
public class MenuService {

   private Menu menuClass;
   private MenuRepo menuRepository;

   public MenuService(Menu menu) {
       this.menu = menu;
   }

   public String menuName() {
       return "WelcomeMenu";
   }
}
