package rest.order.reservation.Model.DTO;

import rest.order.reservation.DefineEnum.MenuType;

public class MenuDTO {
    private String name;
    private String intro;
    private int price;
    private MenuType type;
    
    public MenuDTO(String name, String intro, int price, MenuType type) {
        this.name = name;
        this.intro = intro;
        this.price = price;
        this.type = type;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((intro == null) ? 0 : intro.hashCode());
        result = prime * result + price;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuDTO other = (MenuDTO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (intro == null) {
            if (other.intro != null)
                return false;
        } else if (!intro.equals(other.intro))
            return false;
        if (price != other.price)
            return false;
        if (type != other.type)
            return false;
        return true;
    }
    
    public String getName() {
        return name;
    }
    public String getIntro() {
        return intro;
    }
    public int getPrice() {
        return price;
    }
    public MenuType getType() {
        return type;
    }


}
