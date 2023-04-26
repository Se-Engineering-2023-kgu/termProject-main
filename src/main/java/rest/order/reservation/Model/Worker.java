package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.UserClass;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Worker")
public class Worker extends AppUser {

    @Id
    int WorkerID;
    UserClass uClass;

    public Worker(int userID, String nickName, String loginID, String passWD, UserClass uClass) {
        super(userID, nickName, loginID, passWD);
        this.uClass = uClass;
    }
    


    
}
