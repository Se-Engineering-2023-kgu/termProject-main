package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.OrderMenu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.User.Customer;
import rest.order.reservation.Repository.ReservationRepo;

// @Service
public class ReservationService {
  

  private final ReservationRepo reservationRepo; 
  
  @Autowired
  private Reservation reservation;


  public ReservationService(ReservationRepo reservationRepo) {
    this.reservationRepo = reservationRepo;
    this.reservation = reservation;
    }
    

    public Reservation submitReservation(Menu menu, Customer customer, int count) {
      Reservation reservation = new Reservation();
      OrderService orderService = new OrderService();
      orderService.createOrderMenu(menu,count);

      
      return reservation;
      
    }

  public void name() {
    
  }

}
