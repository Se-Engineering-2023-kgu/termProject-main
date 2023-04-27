package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Repository.BookRepo;

@Service
public class TimeService {

   private BookRepo bookRepo;

   public TimeService(BookRepo bookRepo) {
       this.bookRepo = bookRepo;
   }


}
