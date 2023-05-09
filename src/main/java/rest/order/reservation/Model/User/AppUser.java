package rest.order.reservation.Model.User;


import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "uClass")
public abstract class AppUser {  // 상속을 이용할 것이면 최소한으로 줄여야 할듯

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long uid;
    @Column(name = "login_id")
    private String loginId;

    @Column(name = "login_pwd")
    private String loginPwd;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private UserClass userType;

    public AppUser() {
    }


    public AppUser(Long uid, String loginId, String loginPwd, String name) {
        this.uid = uid;
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
    }

    public AppUser(String loginId, String loginPwd, String name) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
    }

    public void changePassword(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public UserClass getUserType() {
//        return userType;
//    }
//
//    public void setUserType(UserClass userType) {
//        this.userType = userType;
//    }
}
