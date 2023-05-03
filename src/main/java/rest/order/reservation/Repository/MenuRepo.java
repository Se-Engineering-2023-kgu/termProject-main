package rest.order.reservation.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.order.reservation.Model.Menu;

@Repository
public interface MenuRepo extends CrudRepository<Menu, Long> {
    
}
