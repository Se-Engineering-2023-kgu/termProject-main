package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.Book;

public interface RecordsRepo extends JpaRepository<Book, Long>{
    
}
