package rest.order.reservation.Model.User;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "uClass")
public abstract class AppUser {  // 상속을 이용할 것이면 최소한으로 줄여야 할듯
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long uid;
    @Column(name = "login_id")
    private String loginId;
    @Column(name = "login_pwd")
    private String loginPwd;
    @Column(name = "name")
    private String name;

    public AppUser() {
    }

    public AppUser(Long uid, String loginId, String loginPwd, String name) {
        this.uid = uid;
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
    }
}
