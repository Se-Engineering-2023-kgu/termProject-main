package rest.order.reservation.Model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
public class AppUser implements UserDetails { // 상속을 이용할 것이면 최소한으로 줄여야 할듯

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

    private String phoneNumber;

    private String email;

    public AppUser() {
    }

    public AppUser(Long uid, String loginId, String loginPwd, String name, UserClass userType, String phoneNumber,
            String email) {
        this.uid = uid;
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.name = name;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public AppUser(String loginId2, String loginPwd2, List<GrantedAuthority> authorities) {
    }

    public void chageUserInfo(String loginPwd, String phoneNumber, String email) {
        setLoginPwd(loginPwd);
        setPhoneNumber(phoneNumber);
        setEmail(email);
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

    public UserClass getUserType() {
        return userType;
    }

    public void setUserType(UserClass userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add role based on user type
        if (userType == UserClass.customer) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        } else if (userType == UserClass.admin) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_GUEST"));
        }

        return authorities;
    }

    @Override
    public String getPassword() {

        return this.loginPwd;
    }

    @Override
    public String getUsername() {

        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

}
