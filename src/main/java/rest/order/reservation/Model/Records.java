package rest.order.Model;

import jakarta.persistence.*;
import rest.order.reservation.Model.User.Customer;

import java.awt.print.Book;

@Entity
@Table(name = "resRecords")
public class Records {

    // 기록 데이터베이스를 통해 통계 기능을 구현해보고자 함
    // using history database, to add the statistics

    Table table;
    Customer customer;
    Book book;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordID;

    public Records() {
    }

    public Records(Integer recordID, Table table, Customer customer, Book book) {
        this.recordID = recordID;
        this.table = table;
        this.customer = customer;
        this.book = book;
    }


}
