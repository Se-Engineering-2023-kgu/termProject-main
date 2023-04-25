package rest.order.reservation.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import rest.order.Repository.BookRepo;

@Controller
@RequestMapping("/book")
public class BookController {
//    private BookRepo bookRepo;

    @GetMapping("book")
    public String book() {
        return "greeting";
    }

}
