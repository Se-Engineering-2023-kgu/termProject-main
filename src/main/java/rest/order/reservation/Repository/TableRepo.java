package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.Table;

public interface TableRepo extends JpaRepository<Table,Long> {
    
}