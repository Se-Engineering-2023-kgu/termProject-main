package rest.order.reservation.Model.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Customer extends AppUser {

    private String phoneNumber;

    private String email;

//    private UserClass userType;

    public Customer() {
    }

    public Customer(Long uid, String loginId, String loginPwd, String name) {
        super(uid, loginId, loginPwd, name);
        //TODO Auto-generated constructor stub
    }

    public Customer(Long uid, String loginId, String loginPwd, String name, String phoneNumber, String email) {
        super(uid, loginId, loginPwd, name);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Customer(String loginId, String loginPwd, String name, String phoneNumber, String email
    ) {
        super(loginId, loginPwd, name);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //loginPwd , phoneNumber , email 만 바꾸는 메소드
    public void chageCustomerInfo(String loginPwd, String phoneNumber, String email) {
        changePassword(loginPwd);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
