package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.TableList;

public interface TableRepo extends JpaRepository<TableList, Long> {

}
