package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.order.reservation.Repository.BookRepo;

@Service
public class BookingService {
    
  private BookRepo bookRepo; 

  public BookingService(BookRepo bookRepo) {
    this.bookRepo = bookRepo;
    }
    

}
