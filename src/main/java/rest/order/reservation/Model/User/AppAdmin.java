package rest.order.reservation.Model.User;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import rest.order.reservation.DefineEnum.UserClass;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="uClass")
public class AppAdmin extends AppUser {


    public AppAdmin(Integer uid, String loginId, String loginPwd, String name) {
        super(uid, loginId, loginPwd, name);
        //TODO Auto-generated constructor stub
    }

    UserClass uClass;

    
    public AppAdmin(Integer uid, String loginId, String loginPwd, String name, UserClass uClass) {
        super(uid, loginId, loginPwd, name);
        this.uClass = uClass;
    }


}
