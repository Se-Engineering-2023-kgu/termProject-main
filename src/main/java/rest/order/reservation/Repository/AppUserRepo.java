package rest.order.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.order.reservation.Model.User.AppUser;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByLoginId(String loginId);
}
