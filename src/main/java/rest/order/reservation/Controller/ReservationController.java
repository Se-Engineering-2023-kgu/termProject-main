package rest.order.reservation.Controller;


import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.ReservationDTO;
//import rest.order.Repository.BookRepo;

@Slf4j
@Controller

@RequestMapping("/reservation")
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
//    private BookRepo bookRepo;


    //날짜 페이지 접근
    @GetMapping("/date")
    public String reservationDate(Model model) {
        model.addAttribute("reservation", new ReservationDTO());
        return "reservation/reservationDate";
    }

    // 날짜 페이지 값 받고 -> 테이블 선택
    @PostMapping("/date")
    public String reservationDate(@ModelAttribute("reservation") ReservationDTO reservation) {
//        return "reservation/reservationTable";
        return "reservation/reservationInfo";
    }

    // 테이블 선택 값 받고 -> 메뉴 선택
    @PostMapping("/table")
    public String reservationTable(@ModelAttribute("reservation") ReservationDTO reservation) {
        return "reservation/reservationMenu";
    }


    // 메뉴 선택후 -> 예약 명세서
    @PostMapping("/menu")
    public String reservationMenu(@ModelAttribute("reservation") ReservationDTO reservation) {
        return "reservation/reservationInfo";
    }

}
