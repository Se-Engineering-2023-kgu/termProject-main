package rest.order.reservation.Model.User;


public class User {
    int userID;
    String nickName;
    String loginID;
    private String passWD;

    public User(int userID, String nickName, String loginID, String passWD) {
        this.userID = userID;
        this.nickName = nickName;
        this.loginID = loginID;
        this.passWD = passWD;
    }


}
