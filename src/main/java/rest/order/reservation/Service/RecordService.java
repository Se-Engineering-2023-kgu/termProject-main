package rest.order.reservation.Service;

import rest.order.reservation.Repository.RecordsRepo;

public class RecordService {
    private RecordsRepo recordsRepo;

    public RecordService(RecordsRepo recordsRepo) {
        this.recordsRepo = recordsRepo;
    }

}
