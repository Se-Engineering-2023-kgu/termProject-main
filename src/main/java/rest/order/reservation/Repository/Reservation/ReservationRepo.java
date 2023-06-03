package rest.order.reservation.Repository.Reservation;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.User.AppUser;

import java.time.LocalDate;
import java.util.List;


//queryDsl을 사용하기위해서는 새로운 기능을 넣기위한 Custom 인터    페이스와 그걸 구현한 ( 원래이름 : ReservationRepo ) + Impl 형식을 붙인 이름으로 구현후
// 상속을 진행함 -> queryDsl을 사용하는 방식중에 하나입니다.
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>, ReservationRepoCustom {
//    List<Reservation> findByUser(Optional<AppUser> user);
    // List<Reservation> findByMembers(int member);

    List<Reservation> findByUser(AppUser user, Sort sort);

    List<Reservation> findByDateSlotAndTimeSlot(LocalDate date, TimeSlot time);


}
