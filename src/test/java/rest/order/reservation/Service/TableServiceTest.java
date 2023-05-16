package rest.order.reservation.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.TableList;

import java.util.List;

@SpringBootTest
@Transactional
class TableServiceTest {
    @Autowired
    TableService tableService;

    @Test
    void findAllTable() {
        List<TableList> tablelist = tableService.findAllTable();
        System.out.println(tablelist.size()); // 10
    }

    @Test
    void deleteTable() {
        TableList Table = new TableList();
    }

    @Test
    void findTable() {

    }
}