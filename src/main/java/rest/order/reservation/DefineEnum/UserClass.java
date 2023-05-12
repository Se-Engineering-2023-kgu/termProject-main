package rest.order.reservation.DefineEnum;

public enum UserClass {
    guest("     "), admin("관리자"), customer("회원");

    private final String description;

    UserClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
