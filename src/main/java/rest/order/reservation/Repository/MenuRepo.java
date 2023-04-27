package rest.order.reservation.Repository;

import org.springframework.data.repository.CrudRepository;

import rest.order.reservation.Model.Menu;

public interface MenuRepo extends CrudRepository<Menu,Long> {
    
}
