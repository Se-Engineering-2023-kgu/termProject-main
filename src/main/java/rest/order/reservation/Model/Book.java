package rest.order.reservation.Model;

import jakarta.persistence.*;
import rest.order.reservation.Model.User.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "bookinglist")
public class Book implements TimeTable   {
   // need to Declare Database structure
   // how to Book dataBase using Userinfo or any other things;
   // 해당 클래스를 위해선 정확한 데이터베이스 구조 선정이 중요합니다.
   // 구조에 대해서 좀 더 정확한 무언가가 필요해요.

   int customerCount;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer bookingID;

   OrderMenu orderInfo;
   TableList TableInfo;
   Customer customerInfo;



    public Book(Integer bookingID, OrderMenu orderInfo, TableList tableInfo, Customer customerInfo) {
        this.bookingID = bookingID;
        this.orderInfo = orderInfo;
        TableInfo = tableInfo;
        this.customerInfo = customerInfo;
    }

@Override
public LocalTime getArrivalTime() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getArrivalTime'");
}
@Override
public void setArrivalTime(LocalTime time) {
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
public LocalTime getTime() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTime'");
}
@Override
public void setTime(LocalTime time) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setTime'");
}
    

}
