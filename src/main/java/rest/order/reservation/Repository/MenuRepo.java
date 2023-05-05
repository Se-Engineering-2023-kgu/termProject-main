package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rest.order.reservation.Model.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Long> {
    
}
