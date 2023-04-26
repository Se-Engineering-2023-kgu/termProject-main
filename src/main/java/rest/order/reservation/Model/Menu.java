package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.MenuType;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "menu_intro")
    private String intro;
    @Column(name = "price")
    private int price;

    private MenuType type;


    public Menu() {
    }
}
