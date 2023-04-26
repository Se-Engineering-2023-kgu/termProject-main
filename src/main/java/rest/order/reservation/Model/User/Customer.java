package rest.order.reservation.Model.User;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer id;
    @Column(name = "PHONE_NUMBER")
    private String number;
    @Column(name = "EMAIL")
    private String email;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    private UserClass userType;

    public Customer() {
    }

}
