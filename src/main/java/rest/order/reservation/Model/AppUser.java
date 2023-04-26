package rest.order.reservation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Appuser")
public class AppUser {
    @Id
    int userID;
    String nickName;

    String loginID;
    private String passWD;

    public AppUser(int userID, String nickName, String loginID, String passWD) {
        this.userID = userID;
        this.nickName = nickName;
        this.loginID = loginID;
        this.passWD = passWD;
    }


}
