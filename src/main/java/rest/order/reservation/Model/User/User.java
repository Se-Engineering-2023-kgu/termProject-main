package rest.order.reservation.Model.User;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {  // 상속을 이용할 것이면 최소한으로 줄여야 할듯

    @Id
    @Column(name = "USER_ID")
    private Integer uid;

    @Column(name = "LOGIN_ID")
    private String loginId;
    @Column(name = "LOGIN_PWD")
    private String loginPwd;
    @Column(name = "NAME")
    private String name;

    public User() {
    }


}
