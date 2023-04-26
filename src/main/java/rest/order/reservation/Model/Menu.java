package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.MenuType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Menu")
public class Menu {
    //  메뉴라면 가져야 할 것들은? 
    
    @Id
    int MenuID;
    MenuType type;
    int price; 
    String menuNameString;
    int discount;
    int kCal;
    int weight;
    String desCriptionString;
    
    public Menu(MenuType type, int price, String menuNameString, int discount, int kCal, int weight,
            String desCriptionString) {
        this.type = type;
        this.price = price;
        this.menuNameString = menuNameString;
        this.discount = discount;
        this.kCal = kCal;
        this.weight = weight;
        this.desCriptionString = desCriptionString;
    }


}
