package rest.order.reservation.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    @Column(name = "table_no")
    private int number;
    @Column(name = "seats")
    private int seats;
    @Column(name = "on")
    private Boolean exist;

    private String location;


    public Tables() {
    }


}
