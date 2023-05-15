package rest.order.reservation.Repository;

import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.Reservation;

import java.util.List;

public interface ReservationRepoCustom {
    List<Reservation> findAll(ReservationSearch search);
}
