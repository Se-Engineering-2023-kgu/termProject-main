import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import rest.order.reservation.Model.User.Customer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "book")
public class Book {
    // need to Declare Database structure
    // how to Book dataBase using Userinfo or any other things;
    // 해당 클래스를 위해선 정확한 데이터베이스 구조 선정이 중요합니다.
    // 구조에 대해서 좀 더 정확한 무언가가 필요해요.

    SimpleDateFormat bookDateFormat = new SimpleDateFormat("yyyymmdd");
    SimpleDateFormat bookTimeFormat = new SimpleDateFormat("HHmm");
    Calendar bookingDate;
    Calendar bookingTime;
    Customer mainCustomer;
    int customerCount;
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingID;

    public Book() {
    }

    public Book(Integer bookingID, SimpleDateFormat bookDateFormat, SimpleDateFormat bookTimeFormat,
                Calendar bookingDate, Calendar bookingTime, Customer mainCustomer, int customerCount) {
        this.bookingID = bookingID;
        this.bookDateFormat = bookDateFormat;
        this.bookTimeFormat = bookTimeFormat;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.mainCustomer = mainCustomer;
        this.customerCount = customerCount;
    }

}
