package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.Repository.AppUserRepo;
import rest.order.reservation.Repository.MenuRepo;
import rest.order.reservation.Repository.TableRepo;

@Service
public class ReservationService {

    private final AppUserRepo AppUserRepository;
    private final TableRepo tableRepository;
    private final MenuRepo menuRepository;

    public ReservationService(AppUserRepo appUserRepository, TableRepo tableRepository, MenuRepo menuRepository) {
        AppUserRepository = appUserRepository;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
    }
}
