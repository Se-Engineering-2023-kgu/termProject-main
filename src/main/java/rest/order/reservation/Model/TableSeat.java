package rest.order.reservation.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table")
public class TableSeat {
    
    @Id
    int tableNO;
    int seats;

    // How to setting the location
    // need to do 
    String locationString;

    // 예약 대기 리스트 지원에 따라 테이블 큐를 넣어서 순서대로 넣고 빠지는 형태의 메소드 구현이 필요해 보입니다. 
    int tableQue;

    public TableSeat(int tableNO, int seats, String locationString, int tableQue) {
        this.tableNO = tableNO;
        this.seats = seats;
        this.locationString = locationString;
        this.tableQue = tableQue;
    }
    
}
