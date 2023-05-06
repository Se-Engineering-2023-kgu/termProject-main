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
@Table(name = "reservation")
public class Reservation implements TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationID;
    @Column(name = "timeslot")
    @Enumerated(EnumType.STRING)
    private TimeSlot timeSlot;

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

    public Reservation() {
    }

    public Reservation(Long reservationID, TimeSlot timeSlot, Customer user, List<OrderMenu> orderList, TableList tables, int members) {
        this.reservationID = reservationID;
        this.timeSlot = timeSlot;
        this.user = user;
        this.orderList = orderList;
        this.tables = tables;
        this.members = members;
    }


    @Override
    public LocalTime getArrivalTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArrivalTime'");
    }

    @Override
    public void setArrivalTime(TimeSlot timeSlot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setArrivalTime'");
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
    public TimeSlot getTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTime'");
    }

    @Override
    public void setTime(TimeSlot time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTime'");
    }


    // public Book(Integer bookingID, OrderMenu orderInfo, TableList tableInfo,
    // Customer customerInfo) {
    // this.bookingID = bookingID;
    // this.orderInfo = orderInfo;
    // TableInfo = tableInfo;
    // this.customerInfo = customerInfo;
    // }

}
