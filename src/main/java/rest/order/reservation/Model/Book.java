package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.User.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/* 이거 그냥 엔티티 하면 오류남 */
@Entity
// @Table(name = "bookinglist")
public class Book implements TimeTable {
   // need to Declare Database structure
   // how to Book dataBase using Userinfo or any other things;
   // 해당 클래스를 위해선 정확한 데이터베이스 구조 선정이 중요합니다.
   // 구조에 대해서 좀 더 정확한 무언가가 필요해요.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking")
    int bookingID;

   OrderMenu orderInfo;
   TableList TableInfo;
   Customer customerInfo;


   int memberCount;

    public Book() {

    }

    public Book(Integer bookingID, OrderMenu orderInfo, TableList tableInfo, Customer customerInfo) {
        this.bookingID = bookingID;
        this.orderInfo = orderInfo;
        TableInfo = tableInfo;
        this.customerInfo = customerInfo;
    }


}
