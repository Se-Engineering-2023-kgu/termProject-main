package rest.order.reservation.Model;

public class Table {
    
    
    int tableNO;
    int seats;

    // How to setting the location
    // need to do 
    String locationString;

    // 예약 대기 리스트 지원에 따라 테이블 큐를 넣어서 순서대로 넣고 빠지는 형태의 메소드 구현이 필요해 보입니다. 
    int tableQue;

    public Table(int tableNO, int seats, String locationString, int tableQue) {
        this.tableNO = tableNO;
        this.seats = seats;
        this.locationString = locationString;
        this.tableQue = tableQue;
    }
    
}
