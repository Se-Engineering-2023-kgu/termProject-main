package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Repository.CustomerRepo;
import rest.order.reservation.Repository.MenuRepo;
import rest.order.reservation.Repository.TableRepo;

// @Service
public class ReservationService {

    private final CustomerRepo customerRepository;
    private final TableRepo tableRepository;
    private final MenuRepo menuRepository;

    public ReservationService(CustomerRepo customerRepository, TableRepo tableRepository, MenuRepo menuRepository) {
        this.customerRepository = customerRepository;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
    }


}
