package rest.order.reservation.Controller;


import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Service.MenuService;
import rest.order.reservation.Service.ReservationService;
import rest.order.reservation.Service.TableService;

import java.util.List;
//import rest.order.Repository.BookRepo;

@Slf4j
@Controller
//@RequestMapping("")
public class ReservationController {
    private final TableService tableService;
    private final MenuService menuService;
    private final ReservationService reservationService;

    public ReservationController(TableService tableService, MenuService menuService, ReservationService reservationService) {
        this.tableService = tableService;
        this.menuService = menuService;
        this.reservationService = reservationService;
    }

    //1. 날짜 페이지 접근
    @GetMapping("customer/{id}/date")
    public String reservationDate(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", new ReservationForm());
        model.addAttribute("id", id);
        return "reservation/reservationDate";
    }

    // 2. 테이블 선택 페이지
    @PostMapping("customer/{id}/table")
    public String reservationTable(@PathVariable Long id, @ModelAttribute("reservation") ReservationForm reservation, Model model) {
        List<TableList> tableList = tableService.findAllTable();
        List<Menu> menuList = menuService.findAllMenu();
        model.addAttribute("tableList", tableList);
        model.addAttribute("menuList", menuList); // 메뉴리스트 전달
        model.addAttribute("id", id);
        return "reservation/reservationTable";
    }

    @PostMapping("customer/{id}/reserInfo")
    public String reservationInfo(@PathVariable Long id, @ModelAttribute("reservation") ReservationForm reservation, Model model) {
        System.out.println("reservation = " + reservation);
        System.out.println("예약하였습니다.");
        reservationService.addReservation(id, reservation);
        model.addAttribute("id", id);
        model.addAttribute("reservationID", model);

        return "reservation/reservationInfo";


        // members , date , time , id , tableID , orderList
    }

    //   테이블 선택 값 받고 -> 메뉴 선택
//    @PostMapping("customer/{id}//menu")
//    public String reservationMenu(@ModelAttribute("reservation") ReservationForm reservation, Model model) {
//        List<Menu> menuList = menuService.findAllMenu();
//        model.addAttribute("menuList", menuList); // 메뉴리스트 전달
//        return "reservation/reservationMenu";
//    }

    // 주문 목록

}
