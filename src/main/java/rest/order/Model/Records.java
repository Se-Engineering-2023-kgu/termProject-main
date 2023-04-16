package rest.order.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resRecords")
public class Records {

    // 기록 데이터베이스를 통해 통계 기능을 구현해보고자 함 
    // using history database, to add the statistics

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordID;

    Table table;
    Customer customer;
    Book book;
    public Records(Integer recordID, Table table, Customer customer, Book book) {
        this.recordID = recordID;
        this.table = table;
        this.customer = customer;
        this.book = book;
    }

}
