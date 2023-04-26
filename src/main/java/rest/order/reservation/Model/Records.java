package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.Model.User.Customer;


@Entity
@Table(name = "record")
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    @OneToOne
    private Customer customer;
//    private Book book;
    // 기록 데이터베이스를 통해 통계 기능을 구현해보고자 함
    // using history database, to add the statistics


    public Records() {
    }

}
