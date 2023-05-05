package rest.order.reservation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import rest.order.reservation.DefineEnum.MenuType;

@Entity
@Table(name = "menu") // DB 에 menu 테이블이 만들어져요 
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long mid; // PK 로 mid 등록됨 
    
    
    @Column(name = "menu_name")
    private String name;
    @Column(name = "menu_intro")
    private String intro;
    @Column(name = "price")
    private Long price;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MenuType type;

    public Menu() {
        
    }

    public Menu(Long mid, String name, String intro, Long price, MenuType type) {
        this.mid = mid;
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.type = type;
    }

    public Menu(String name2, String intro2, Long price2, MenuType type2) {
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }




}
