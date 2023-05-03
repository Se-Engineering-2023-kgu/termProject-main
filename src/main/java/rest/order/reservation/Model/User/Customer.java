package rest.order.reservation.Model.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
@DiscriminatorValue("customer")
public class Customer extends AppUser {

    private String phoneNumber;

    private String email;

    private UserClass userType;

    public Customer() {
    }

    public Customer(Long uid, String loginId, String loginPwd, String name) {
        super(uid, loginId, loginPwd, name);
        //TODO Auto-generated constructor stub
    }

    public Customer(Long uid, String loginId, String loginPwd, String name, String phoneNumber, String email,
                    UserClass userType) {
        super(uid, loginId, loginPwd, name);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userType = userType;
    }

}
