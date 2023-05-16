package rest.order.reservation.DefineEnum;

public enum MenuType {
    Beverage("음료"), Desert("디저트"), Appetizers("에피타이저"), MainCuisine("메인"), side("사이드");


    private final String description;

    MenuType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
