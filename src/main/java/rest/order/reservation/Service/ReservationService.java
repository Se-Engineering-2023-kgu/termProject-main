package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Repository.CustomerRepo;
import rest.order.reservation.Repository.MenuRepo;
import rest.order.reservation.Repository.TableRepo;

@Service
public class ReservationService {

    private final CustomerRepo customerRepository;
    private final TableRepo tableRepository;
    private final MenuRepo menuRepository;

    public ReservationService(CustomerRepo customerRepository, TableRepo tableRepository, MenuRepo menuRepository) {
        this.customerRepository = customerRepository;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
    }

//    public Long Reservation(Long customerID, Long tableID) {
//        Customer customer = customerRepository.findById(customerID).get();
//        TableList table = tableRepository.findById(tableID).get();
//
//    }
//    public Reservation submitReservation(Menu menu, Customer customer, int count) {
//      Reservation reservation = new Reservation();
//      OrderService orderService = new OrderService();
//      orderService.createOrderMenu(menu,count);
//
//
//      return reservation;
//
//    }


}
