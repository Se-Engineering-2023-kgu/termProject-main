package rest.order.reservation.Model.User;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.UserClass;

@Entity
@Table(name = "admin")
public class Admin {

    UserClass uClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private Integer id;
    @Column(name = "ADMIN_NAME")
    private String name;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Admin() {
    }

}
