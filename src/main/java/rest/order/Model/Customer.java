package rest.order.Model;

import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import rest.order.DefineEnum.UserClass;

public class Customer extends AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
