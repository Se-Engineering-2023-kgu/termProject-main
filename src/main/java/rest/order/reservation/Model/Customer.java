package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.UserClass;

public class Customer extends AppUser {

    String phoneNumberString;
    String emailString;
    String customerNameString;
    UserClass userType;
    public Customer(int userID, String nickName, String loginID, String passWD, String phoneNumberString,
            String emailString, String customerNameString, UserClass userType) {
        super(userID, nickName, loginID, passWD);
        this.phoneNumberString = phoneNumberString;
        this.emailString = emailString;
        this.customerNameString = customerNameString;
        this.userType = userType;
    }
    
}
