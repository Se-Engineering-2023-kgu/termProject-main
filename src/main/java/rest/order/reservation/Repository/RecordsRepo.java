package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.Records;

public interface RecordsRepo extends JpaRepository<Records, Long>{
    
}
