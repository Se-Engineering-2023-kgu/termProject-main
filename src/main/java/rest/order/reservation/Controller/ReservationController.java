package rest.order.reservation.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import rest.order.Repository.BookRepo;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
//    private BookRepo bookRepo;

    @GetMapping("/reservation")
    public String book() {
        return "greeting";
    }

}
