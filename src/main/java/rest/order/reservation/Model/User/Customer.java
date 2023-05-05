package rest.order.reservation.Model.User;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.DTO.CustomerDTO;
import rest.order.reservation.Model.DTO.CustomerDTOMapper;

@Entity
@DiscriminatorValue("customer")
public class Customer extends AppUser {

    private String phoneNumber;

    private String email;

    private UserClass userType;

    public Customer() {
    }

    public Customer(Long uid, String loginId, String loginPwd, String name) {
        super(uid, loginId, loginPwd, name);
    }

    public Customer(Long uid, String loginId, String loginPwd, String name, String phoneNumber, String email,
                    UserClass userType) {
        super(uid, loginId, loginPwd, name);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userType = userType;
    }

    public Customer(String loginId, String loginPwd, String name, String phoneNumber2, String email2,
			UserClass userType2) {
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

    public UserClass getUserType() {
        return userType;
    }

    public void setUserType(UserClass userType) {
        this.userType = userType;
    }

    @Override
    public String getLoginId() {
        // TODO Auto-generated method stub
        return super.getLoginId();
    }

    @Override
    public String getLoginPwd() {
        // TODO Auto-generated method stub
        return super.getLoginPwd();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return super.getName();
    }

    @Override
    public Long getUid() {
        // TODO Auto-generated method stub
        return super.getUid();
    }

    @Override
    public void setLoginId(String loginId) {
        // TODO Auto-generated method stub
        super.setLoginId(loginId);
    }

    @Override
    public void setLoginPwd(String loginPwd) {
        // TODO Auto-generated method stub
        super.setLoginPwd(loginPwd);
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        super.setName(name);
    }

    @Override
    public void setUid(Long uid) {
        // TODO Auto-generated method stub
        super.setUid(uid);
    }

	public CustomerDTO map(CustomerDTOMapper customerDTOMapper) {
		return null;
	}



}
