package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.UserClass;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Customer")
public class Customer extends AppUser {


    String phoneNumberString;
    @Id
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
