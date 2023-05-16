package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.OrderMenu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final AppUserRepo appUserRepository;
    private final TableRepo tableRepository;
    private final MenuRepo menuRepository;
    private final OrderMenuRepo orderMenuRepository;

    private final ReservationRepo reservationRepository;

    public ReservationService(AppUserRepo appUserRepository, TableRepo tableRepository, MenuRepo menuRepository, OrderMenuRepo orderMenuRepository, rest.order.reservation.Repository.ReservationRepo reservationRepository) {
        this.appUserRepository = appUserRepository;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
        this.orderMenuRepository = orderMenuRepository;
        this.reservationRepository = reservationRepository;
    }

    // 주문 등록
    public Long addReservation(Long id, ReservationForm form) {

        //View 에서 전달되어진 값
        // 1. customerId
        // 2. ReservationForm : 예약인원 , 날짜 , 시간 , 테이블(번호) , 주문한 메뉴들 종류(List)

        // 엔티티 조회
        AppUser user = appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("reservation add appUser : " + id));  // customerId로 회원 찾기
        Long tid = form.getTid();                             // tableId
        TableList tables = tableRepository.findById(tid).orElseThrow(() -> new RuntimeException("reservation update tables : " + tid)); // tableId로 table찾기

        // ReservationForm 내부에서 값 전달되어 있는지 확인용
        int members = form.getMembers();                    // 인원수
        LocalDate date = LocalDate.parse(form.getDate());   // 날짜
        TimeSlot time = form.getTime();                     // 시간

        List<OrderMenu> userOrderMenuList = new ArrayList<>();  // Reservation Entity가 가지고 있는 List<OrderMenu> orderList 에 넣기위한 리스트 입니다.
        // 처음 예약하는 시점마다 고객이 주문하는 메뉴들이 다르기 때문에 빈 list로 설정했습니다.
        // 하지만 제가 저번주에 예약이 삭제될지 안될지 걱정한것에 1번 이유입니다.

        for (Long mid : form.getOrderMenuList()) {                          // Reservationform 에서 받아온 여러가지 주문 상품 종류 mid : Long 타입으로 받아옴
            Menu menu = menuRepository.findById(mid).get();                 // 받아온 long 타입 id 로 menu 종류 찾고
            OrderMenu orderMenu = OrderMenu.createOrderMenu(menu, 1); // 개수는 지정하지 못했음.... 1개
            userOrderMenuList.add(orderMenu);                               // 53번 line 이유로 userOrderMenuList에 찾은 orderMenu를 넣어줍니다.
        }

        // 주문 생성
        // 몇몇 로직들이 있어서 DTO 사용 X
        Reservation reservation = Reservation.createReservation(user, members, tables, date, time, userOrderMenuList); // Reservation 생성
        reservationRepository.save(reservation); // 주문 저장
        return reservation.getReservationID();   // 주문 id 반환  --> Test 할때보니 생성할때 id 반환해주는것이 쉽더군요
    }

//    public List<Reservation> findAllReservation() {
//        return reservationRepository.findAll();
//    }

    public List<Reservation> findAllReservation(ReservationSearch reservationSearch) {

        return reservationRepository.findAll(reservationSearch);
    }

    // 예약 삭제 : db 기준으로 reservationId 의 orderList들을 모두 삭제해야 -> reservationId가 삭제될 것 같다. : orderList에는 cascade가 없으므로
    @Transactional
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("reservation delete reservation : " + id));
        for (OrderMenu orderMenu : reservation.getOrderList())
            orderMenuRepository.delete(orderMenu);
        reservationRepository.delete(reservation);
    }

    // RegisterForm으로 다시 받아와 예약 수정
    @Transactional
    public void updateReservation(Long id, ReservationForm form) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("reservation update reservation : " + id));  // 여기서는 null 체크 해야함

        Long tid = form.getTid();
        TableList tables = tableRepository.findById(tid).orElseThrow(() -> new RuntimeException("reservation update tables : " + tid));
        int members = form.getMembers();
        LocalDate date = LocalDate.parse(form.getDate());
        TimeSlot time = form.getTime();

        List<OrderMenu> userOrderMenuList = new ArrayList<>();
        for (Long mid : form.getOrderMenuList()) {
            Menu menu = menuRepository.findById(mid).orElseThrow(() -> new RuntimeException("reservation update menu : " + mid));
            OrderMenu orderMenu = OrderMenu.createOrderMenu(menu, 1);
            userOrderMenuList.add(orderMenu);
        }
        reservation.changeReservationInfo(members, tables, date, time, userOrderMenuList);
    }

}
