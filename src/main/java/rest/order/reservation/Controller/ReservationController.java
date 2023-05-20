package rest.order.reservation.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.DTO.Reservation.form.ReservationDateForm;
import rest.order.reservation.Model.DTO.Reservation.form.ReservationTableForm;
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

    //0. 날짜 페이지 접근
    @GetMapping("customer/{id}/date")
    public String reservationGet(@PathVariable Long id, Model model) {

        model.addAttribute("reservation", new ReservationForm());
        model.addAttribute("id", id);
        return "reservation/reservationDate";
    }

    // 1. 날짜 페이지 검증 -> 테이블 선택 페이지
    @PostMapping("customer/{id}/date")
    public String reservationDate(@PathVariable Long id, @Validated @ModelAttribute("reservation") ReservationDateForm reservation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/customer/{id}/date";
        }
        List<TableList> tableList = tableService.findAllTable();
        model.addAttribute("tableList", tableList);
        model.addAttribute("id", id);

        return "reservation/reservationTable";
    }

    // 2. table 선택 검증 -> 메뉴 선택 페이지
    @PostMapping("customer/{id}/table")
    public String reservationTable(@PathVariable Long id, @Validated @ModelAttribute("reservation") ReservationTableForm reservation, BindingResult bindingResult, Model model) {

        log.info("reservation : {}", reservation);
        List<Menu> menuList = menuService.findAllMenu();
        model.addAttribute("menuList", menuList);
        model.addAttribute("id", id);
        return "reservation/reservationMenu";
    }

    //   3. menu 선택 검증 -> 예약 명세서
    @PostMapping("customer/{id}/menu")
    public String reservationMenu(@PathVariable Long id, @Validated @ModelAttribute("reservation") ReservationForm reservation, Model model) {

        log.info("reservation:{}", reservation);
        model.addAttribute("id", id);
        TableList table = tableService.findTable(reservation.getTid());
        model.addAttribute("tables", table);
        log.info("에약화면으로 이동합니다.");
        return "reservation/reservationInfo";
    }

    @PostMapping("customer/{id}/reservationInfo")
    public String reservationInfo(@PathVariable Long id, @ModelAttribute("reservation") ReservationForm reservation, Model model) {
        System.out.println("reservation = " + reservation);
        System.out.println("예약하였습니다.");
        log.info("reservation : {}", reservation);
        reservationService.addReservation(id, reservation);
        model.addAttribute("id", id);
        model.addAttribute("reservationID", model);

        return "redirect:/customer/{id}";
        // members , date , time , id , tableID , orderList
    }


}
