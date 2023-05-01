package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Book;
import rest.order.reservation.Repository.BookRepo;

@Service
public class BookingService {
    
  private BookRepo bookRepo; 
  private Book book;

  public BookingService(BookRepo bookRepo) {
    this.bookRepo = bookRepo;
    }
    

}
