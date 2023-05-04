package rest.order.reservation.Model.DTO;

import rest.order.reservation.DefineEnum.MenuType;

public class MenuDTO {
    private String name;
    private String intro;
    private int price;
    private MenuType type;

    public MenuDTO() {
    }

    public MenuDTO(String name, String intro, int price, MenuType type) {
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.type = type;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
}
