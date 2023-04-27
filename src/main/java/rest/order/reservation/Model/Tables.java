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
    @Column(name = "occupied")
    private Boolean exist;
    // private String location;
    // 현재로선 로케이션 정보는 프론트엔드에서 시각적으로 표현해야 할 것 같습니다. 


    public Tables(Integer tid, int number, int seats, Boolean exist) {
        this.tid = tid;
        this.number = number;
        this.seats = seats;
        this.exist = exist;
    }

    
    
}
