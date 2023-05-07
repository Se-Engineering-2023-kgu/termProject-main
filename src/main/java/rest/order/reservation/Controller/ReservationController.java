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
import rest.order.reservation.Service.TableService;

import java.util.List;
//import rest.order.Repository.BookRepo;

@Slf4j
@Controller

@RequestMapping("/reservation")
public class ReservationController {
    private final TableService tableService;
    private final MenuService menuService;

    public ReservationController(TableService tableService, MenuService menuService) {
        this.tableService = tableService;
        this.menuService = menuService;
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

    //         테이블 선택 값 받고 -> 메뉴 선택
    @PostMapping("/menu")
    public String reservationMenu(@ModelAttribute("reservation") ReservationForm reservation, Model model) {
        List<Menu> menuList = menuService.findAllMenu();
        
        return "reservation/reservationMenu";
    }

    @PostMapping("/Info")
    public String reservationInfo(@ModelAttribute("reservation") ReservationForm reservation, Model model) {

        return "reservation/reservationMenu";
    }

//    // table 디자인 용
//    @GetMapping("/table")
//    public String reservationTable(Model model) {
//        model.addAttribute("reservation", new ReservationForm());
//        return "reservation/reservationTable";
//    }
//
//    // 테이블 디자인용
//    @GetMapping("/menu")
//    public String reservationMenu(Model model) {
//        model.addAttribute("reservation", new ReservationForm());
//        return "reservation/reservationMenu";
//    }
//
    // 2. 테이블 화면

//
//    // 3 .메뉴 선택후 -> 예약 명세서
//    @GetMapping("/menu")
//    public String reservationMenuGET(@ModelAttribute("reservation") ReservationForm reservation) {
//        return "reservation/reservationMenu";
//    }


    // 날짜 페이지 값 받고 -> 테이블 선택
//    @PostMapping("/date")
//    public String reservationDate(@ModelAttribute("reservation") ReservationDTO reservation) {
////        return "reservation/reservationTable";
//        return "reservation/reservationInfo";
//    }


//    @PostMapping("/menu")
//    public String reservationMenuPOST(@ModelAttribute("reservation") ReservationDTO reservation) {
//        return "reservation/reservationInfo";
//    }

}
