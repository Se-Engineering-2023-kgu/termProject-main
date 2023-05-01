package rest.order.reservation.Service;

import org.springframework.stereotype.Service;

import rest.order.reservation.Model.TableList;
import rest.order.reservation.Repository.TableRepo;

@Service
public class TableService {

    TableRepo tService;
    TableList tList;

    public TableService(TableRepo tService, TableList tList) {
        this.tService = tService;
        this.tList = tList;
    }

    public TableService() {

    }

}
