package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Model.Booking;

@Service
public class TimeService {

   private Booking bookRepo;

   public TimeService(Booking bookRepo) {
       this.bookRepo = bookRepo;
   }


}
