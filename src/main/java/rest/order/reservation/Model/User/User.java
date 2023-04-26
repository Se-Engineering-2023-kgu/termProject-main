package rest.order.reservation.Model.User;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class User {  // 상속을 이용할 것이면 최소한으로 줄여야 할듯
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer uid;
    private String loginId;
    private String loginPwd;
    private String name;

    public User() {
    }


}
