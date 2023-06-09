package rest.order.reservation.Repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.order.reservation.Model.User.AppUser;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>, AppUserRepoCustom {

    Optional<AppUser> findByLoginId(String loginId);

}
