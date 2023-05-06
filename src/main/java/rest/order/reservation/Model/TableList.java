package rest.order.reservation.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tableList")
public class TableList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tid;
    @Column(name = "table_no", columnDefinition = "int")
    private int number;
    @Column(name = "seats", columnDefinition = "int")
    private int seats;
    @Column(name = "occupied", columnDefinition = "boolean")
    private Boolean exist;
    // private String location;
    // 현재로선 로케이션 정보는 프론트엔드에서 시각적으로 표현해야 할 것 같습니다. 


    public TableList(Long tid, int number, int seats, Boolean exist) {
        this.tid = tid;
        this.number = number;
        this.seats = seats;
        this.exist = exist;
    }

    public TableList() {
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}
