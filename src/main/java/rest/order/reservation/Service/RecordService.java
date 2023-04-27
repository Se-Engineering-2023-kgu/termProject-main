package rest.order.reservation.Service;

import rest.order.reservation.Model.Booking;

public class RecordService {
   private Booking recordsRepo;

   public RecordService(BookRepo recordsRepo) {
       this.recordsRepo = recordsRepo;
   }

}
