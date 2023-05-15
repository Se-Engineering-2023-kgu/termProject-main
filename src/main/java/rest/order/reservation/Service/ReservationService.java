package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.OrderMenu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.AppUserRepo;
import rest.order.reservation.Repository.MenuRepo;
import rest.order.reservation.Repository.ReservationRepo;
import rest.order.reservation.Repository.TableRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final AppUserRepo appUserRepository;
    private final TableRepo tableRepository;
    private final MenuRepo menuRepository;

    private final ReservationRepo reservationRepository;

    public ReservationService(AppUserRepo appUserRepository, TableRepo tableRepository, MenuRepo menuRepository, ReservationRepo reservationRepository) {
        this.appUserRepository = appUserRepository;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
        this.reservationRepository = reservationRepository;
    }

    // 주문 등록
    public Long addReservation(Long id, ReservationForm form) {

        // 엔티티 조회
        AppUser user = appUserRepository.findById(id).get();
        Long tid = form.getTid();
        TableList tables = tableRepository.findById(tid).get(); // table

        // only 값 확인
        int members = form.getMembers(); // 인원수
        LocalDate date = LocalDate.parse(form.getDate()); // 날짜
        TimeSlot time = form.getTime();                   // 시간

        List<OrderMenu> userOrderMenuList = new ArrayList<>();  // 유저가 주문한 주문 메뉴 리스트

        for (Long mid : form.getOrderMenuList()) {                           // form 에서 받아온 여러가지 주문 상품 종류 mid : Long 타입으로 받아옴
            Menu menu = menuRepository.findById(mid).get();                  // 받아온 long 타입 id 로 mene 종류 찾고
            OrderMenu orderMenu = OrderMenu.createOrderMenu(menu, 1);  // 개수는 지정하지 못했음.... 1개
            userOrderMenuList.add(orderMenu);                                // 새로정의한 userOrderMenuList 에 추가
        }
        
        // 주문 생성
        // 몇몇 로직들이 있어서 DTO 사용 X
        Reservation reservation = Reservation.createReservation(user, members, tables, date, time, userOrderMenuList);
        reservationRepository.save(reservation); // 주문 저장 
        return reservation.getReservationID();   // 주문 id 반환 
    }

}
