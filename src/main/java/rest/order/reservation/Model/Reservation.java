package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.User.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/* 이거 그냥 엔티티 하면 오류남 */
@Entity
// @Table(name = "bookinglist")
public class Reservation implements TimeTable {
    // need to Declare Database structure
    // how to Book dataBase using Userinfo or any other things;
    // 해당 클래스를 위해선 정확한 데이터베이스 구조 선정이 중요합니다.
    // 구조에 대해서 좀 더 정확한 무언가가 필요해요.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    int reservationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer user;  // 고객 1 - 예약 n

    // 단방향을 생각해야하지만 , 예약에 다른 종류의 OrderMenuList가 있을 것 같아서 표현
    // FK 가 예약에 있기 때문에 mappedBy
    // OrderMenu는 무조건 예약에만 연관되어 있기 때문에 cascade 설정
    // cascade : 예약 입력시 해당 orderMenu를 자동으로 넣어줄 수 있다고함 --> 잘 모르겠음
    @OneToMany(mappedBy = "reservationID", cascade = CascadeType.ALL)
    private List<OrderMenu> orderList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tables_id")
    private TableList tables;

    @Column(name = "members")
    private int members; // 인원수


    @Column(name = "timeslot")
    @Enumerated(EnumType.STRING)
    TimeSlot timeSlot;

    public Reservation(int reservationID, Customer user, List<OrderMenu> orderList, TableList tables, int members,
            TimeSlot timeSlot) {
        this.reservationID = reservationID;
        this.user = user;
        this.orderList = orderList;
        this.tables = tables;
        this.members = members;
        this.timeSlot = timeSlot;
    }

    public Reservation() {
        
    }

    @Override
    public LocalTime getArrivalTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArrivalTime'");
    }


    @Override
    public LocalDate getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public void setDate(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }


    @Override
    public void setArrivalTime(TimeSlot timeSlot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setArrivalTime'");
    }

    @Override
    public void setTime(TimeSlot time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTime'");
    }

    @Override
    public TimeSlot getTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }



    // public Book(Integer bookingID, OrderMenu orderInfo, TableList tableInfo,
    // Customer customerInfo) {
    // this.bookingID = bookingID;
    // this.orderInfo = orderInfo;
    // TableInfo = tableInfo;
    // this.customerInfo = customerInfo;
    // }

}
