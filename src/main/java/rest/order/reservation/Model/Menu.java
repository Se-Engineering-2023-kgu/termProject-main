package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.MenuType;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int mid;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "menu_intro")
    private String intro;
    @Column(name = "price")
    private int price;

    @Column(name = "type")
    private MenuType type;

    public Menu() {
        
    }

    public Menu(Integer mid, String name, String intro, int price, MenuType type) {
        this.mid = mid;
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.type = type;
    }

}
