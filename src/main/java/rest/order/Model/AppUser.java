package rest.order.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
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
