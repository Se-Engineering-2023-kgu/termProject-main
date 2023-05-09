package rest.order.reservation.Model.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
@DiscriminatorValue("admin")
public class AppAdmin extends AppUser {
    @Enumerated(EnumType.STRING)
    private UserClass userType;

    public AppAdmin(Long uid, String loginId, String loginPwd, String name) {
        super(uid, loginId, loginPwd, name);
        //TODO Auto-generated constructor stub
    }

    public AppAdmin() {
    }

    public AppAdmin(Long uid, String loginId, String loginPwd, String name, UserClass userType) {
        super(uid, loginId, loginPwd, name);
        this.userType = userType;
    }

}
