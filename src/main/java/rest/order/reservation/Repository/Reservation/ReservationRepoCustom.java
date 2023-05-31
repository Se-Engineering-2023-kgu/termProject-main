package rest.order.reservation.Repository.Reservation;

import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.Reservation;

import java.util.List;


//새로운 기능을 넣기 위한 Custom 인터페이스
public interface ReservationRepoCustom {
    List<Reservation> findAll(ReservationSearch search);
}
