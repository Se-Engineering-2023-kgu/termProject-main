package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.UserClass;

public class Worker extends AppUser {


    UserClass uClass;

    public Worker(int userID, String nickName, String loginID, String passWD, UserClass uClass) {
        super(userID, nickName, loginID, passWD);
        this.uClass = uClass;
    }
    


    
}
