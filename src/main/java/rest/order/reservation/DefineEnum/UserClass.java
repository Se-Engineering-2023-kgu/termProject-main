package rest.order.reservation.DefineEnum;

public enum UserClass {
    admin("관리자"), guest("게스트"), customer("회원");


    private final String description;

    UserClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
