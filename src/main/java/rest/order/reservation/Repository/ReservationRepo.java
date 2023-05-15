package rest.order.reservation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.order.reservation.Model.Reservation;

/*
 * JpaRepository == SQL을 적당하게 만들어주는 편한 라이브러리라고 생각하시면 좋습니다.
 * 편한 라이브러리라고 막 쓰면 저세상 가기 딱 좋습니다만
 * 일단 무엇인가를 하기 위해서 쓰는 것인 만큼 이게 유용할 겁니다.
 */


//queryDsl을 사용하기위해서는 새로운 기능을 넣기위한 Custom 인터페이스와 그걸 구현한 ( 원래이름 : ReservationRepo ) + Impl 형식을 붙인 이름으로 구현후
// 상속을 진행함 -> queryDsl을 사용하는 방식중에 하나입니다.
@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>, ReservationRepoCustom {


}
