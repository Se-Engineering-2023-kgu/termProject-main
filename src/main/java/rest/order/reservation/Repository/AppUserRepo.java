package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.User.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser,Long>{
    
}
