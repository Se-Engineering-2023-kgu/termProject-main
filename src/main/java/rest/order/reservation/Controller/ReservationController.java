package rest.order.reservation.Controller;


import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/reservation")
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
    @GetMapping("/date")
    public String reservationDate(Model model) {
        model.addAttribute("reservation", new ReservationForm());
        return "reservation/reservationDate";
    }

    // 2. 테이블 선택 페이지
    @PostMapping("/table")
    public String reservationTable(@ModelAttribute("reservation") ReservationForm reservation, Model model) {
        List<TableList> tableList = tableService.findAllTable();
        model.addAttribute("tableList", tableList);
        return "reservation/reservationTable";
    }

    //   테이블 선택 값 받고 -> 메뉴 선택
    @PostMapping("/menu")
    public String reservationMenu(@ModelAttribute("reservation") ReservationForm reservation, Model model) {
        List<Menu> menuList = menuService.findAllMenu();
        model.addAttribute("menuList", menuList); // 메뉴리스트 전달
        return "reservation/reservationMenu";
    }

    // 주문 목록
    @PostMapping("/Info")
    public String reservationInfo(@ModelAttribute("reservation") ReservationForm reservation, Model model) {
        
        return "reservation/reservationInfo";

        // members , date , time , customerID , tableID , orderList
    }
}
