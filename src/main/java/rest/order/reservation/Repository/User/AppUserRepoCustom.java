package rest.order.reservation.Repository.User;

import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.AppUserSearch;

import java.util.List;

public interface AppUserRepoCustom {
    List<AppUser> findAll(AppUserSearch search);
}
