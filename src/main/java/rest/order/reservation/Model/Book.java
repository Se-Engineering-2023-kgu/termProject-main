package rest.order.reservation.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements TimeTable {
   // need to Declare Database structure
   // how to Book dataBase using Userinfo or any other things;
   // 해당 클래스를 위해선 정확한 데이터베이스 구조 선정이 중요합니다.
   // 구조에 대해서 좀 더 정확한 무언가가 필요해요.

   int customerCount;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer bookingID;


   public Book() {
   }


   @Override
   public LocalTime getArrivalTime() {
       return null;
   }

   @Override
   public void setArrivalTime(LocalTime time) {

   }

   @Override
   public LocalDate getDate() {
       return null;
   }

   @Override
   public void setDate(LocalDate date) {

   }

   @Override
   public LocalTime getTime() {
       return null;
   }

   @Override
   public void setTime(LocalTime time) {

   }

   @Override
   public List<Tables> getTables() {
       return null;
   }

   @Override
   public void setTables(List<Tables> tablesList) {

   }
}
