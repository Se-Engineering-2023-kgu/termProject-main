package rest.order.reservation.Model.User;

import rest.order.reservation.DefineEnum.UserClass;

public class Customer extends User {

    String phoneNumber;
    String email;
    String customerName;
    UserClass userType;

    public Customer(int userID, String nickName, String loginID, String passWD, String phoneNumber,
                    String email, String customerName, UserClass userType) {

        super(userID, nickName, loginID, passWD);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerName = customerName;
        this.userType = userType;
    }

}
