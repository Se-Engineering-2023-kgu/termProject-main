package rest.order.reservation.Model.User;

import jakarta.persistence.Entity;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
public class Customer extends AppUser {

    private String number;
    private String email;

    private UserClass userType;

    public Customer() {
    }

}
