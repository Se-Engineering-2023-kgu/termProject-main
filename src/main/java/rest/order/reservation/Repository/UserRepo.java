package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.order.reservation.Model.User.AppUser;


public interface UserRepo extends JpaRepository<AppUser, Long> {

}
