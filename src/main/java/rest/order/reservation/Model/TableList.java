package rest.order.reservation.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tableList")
public class TableList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;
    @Column(name = "table_no", columnDefinition = "int")
    private long number;
    @Column(name = "seats", columnDefinition = "int")
    private long seats;
    @Column(name = "occupied", columnDefinition = "boolean")
    private Boolean exist;
    // private String location;
    // 현재로선 로케이션 정보는 프론트엔드에서 시각적으로 표현해야 할 것 같습니다. 

    public TableList(int tid, int number, int seats, Boolean exist) {
        this.tid = tid;
        this.number = number;
        this.seats = seats;
        this.exist = exist;
    }

    public TableList(){

    }

    
}
