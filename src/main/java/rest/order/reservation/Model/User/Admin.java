package rest.order.reservation.Model.User;

import jakarta.persistence.Entity;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
public class Admin extends AppUser {

    UserClass uClass;

    public Admin() {
    }

}
