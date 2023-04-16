package rest.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.Model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long>{
    
}
