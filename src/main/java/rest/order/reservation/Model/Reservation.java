package rest.order.reservation.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.User.AppUser;

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

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSlot;  // date 이름이 겹칩니다!
    @Column(name = "timeslot")
    @Enumerated(EnumType.STRING)
    private TimeSlot timeSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AppUser user;  // 고객 1 - 예약 n

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

//    private Long customerId; // customerId 프로퍼티 추가 -> 삭제


    public Reservation() {
    }

    public Reservation(Long reservationID, TimeSlot timeSlot, AppUser user, List<OrderMenu> orderList, TableList tables, int members) {
        this.reservationID = reservationID;
        this.timeSlot = timeSlot;
        this.user = user;
        this.orderList = orderList;
        this.tables = tables;
        this.members = members;
    }

    public static Reservation createReservation(AppUser user, int members, TableList tables, LocalDate date, TimeSlot time, List<OrderMenu> userOrderMenuList) {
//
        Reservation reservation = new Reservation();  // OrderMenu에 생성자로 썼으니 Reservation에서는 set으로 써봤습니다 ㅋ..
        reservation.setUser(user);
        reservation.setMembers(members);
        reservation.setTables(tables);
        reservation.setDateSlot(date);
        reservation.setTimeSlot(time);
//
        for (OrderMenu orderMenu : userOrderMenuList) {  // 여기가 제가 수정,삭제가 될지 걱정하는 부분 2번 입니다.
            reservation.addOrderMenu(orderMenu);
        }
        return reservation;
//    }
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        orderList.add(orderMenu);           // reservation에 존재하는 orderList에 orderMenu를 추가해줌
        orderMenu.setReservationID(this);   // 추가한 orderMenu 에 맵핑된 reservationId를 지정해줌   --> 걱정 2번 이부분(외래키 지정) 때문에 Reservation의 orderList를 지울까 고민중입니다...
    }

    public void changeReservationInfo(int members, TableList tables, LocalDate date, TimeSlot time, List<OrderMenu> newOrderMenuList) {
        setMembers(members);
        setTables(tables);
        setDateSlot(date);
        setTimeSlot(time);

        for (OrderMenu orderMenu : newOrderMenuList) {
            addOrderMenu(orderMenu);
        }
    }


    //    public void removeOrderMenu(OrderMenu orderMenu) {
//        this.orderList.remove(orderMenu);
//        orderMenu.setReservationID(null);
//
//    }
    public OrderMenu removeOrderMenu(OrderMenu orderMenu) {
        this.orderList.remove(orderMenu);
        orderMenu.setReservationID(null);
        return orderMenu;
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public LocalDate getDateSlot() {
        return dateSlot;
    }

    public void setDateSlot(LocalDate dateSlot) {
        this.dateSlot = dateSlot;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<OrderMenu> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMenu> orderList) {
        this.orderList = orderList;
    }

    public TableList getTables() {
        return tables;
    }

    public void setTables(TableList tables) {
        this.tables = tables;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
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
