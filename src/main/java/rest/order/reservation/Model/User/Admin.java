package rest.order.reservation.Model.User;

import rest.order.reservation.DefineEnum.UserClass;

public class Admin extends User {

    UserClass uClass;

    public Admin(int userID, String nickName, String loginID, String passWD, UserClass uClass) {
        super(userID, nickName, loginID, passWD);
        this.uClass = uClass;
    }


}
