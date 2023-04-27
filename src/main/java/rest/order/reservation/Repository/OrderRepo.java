package rest.order.reservation.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rest.order.reservation.Model.OrderMenu;

@Repository
public interface OrderRepo extends CrudRepository<OrderMenu, Long> {
    
}
