package rest.order.reservation.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.order.reservation.Model.User.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

}
