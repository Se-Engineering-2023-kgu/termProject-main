package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.TableSeat;

public interface TableRepo extends JpaRepository<TableSeat,Long> {
    
}
