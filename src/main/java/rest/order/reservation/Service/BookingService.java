package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Model.Booking;

@Service
public class BookingService {

   private Booking bookRepo;

   public BookingService(Booking bookRepo) {
       this.bookRepo = bookRepo;
   }


}
