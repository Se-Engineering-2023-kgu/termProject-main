package rest.order.reservation.Repository;

import org.springframework.data.repository.CrudRepository;

import rest.order.reservation.Model.OrderMenu;

public interface OrderRepo extends CrudRepository<OrderMenu, Long> {
    
}
