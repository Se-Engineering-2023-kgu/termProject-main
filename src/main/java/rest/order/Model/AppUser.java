package rest.order.Model;


public class AppUser {
    int userID;
    String nickName;

    String loginID;
    private String passWD;

    public AppUser(int userID, String nickName, String loginID, String passWD) {
        this.userID = userID;
        this.nickName = nickName;
        this.loginID = loginID;
        this.passWD = passWD;
    }


}
