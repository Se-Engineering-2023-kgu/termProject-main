package rest.order.Model;

import rest.order.DefineEnum.MenuType;

public class Menu {
    //  메뉴라면 가져야 할 것들은? 

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
