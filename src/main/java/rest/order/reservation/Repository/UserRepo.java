package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long>{
    
}
