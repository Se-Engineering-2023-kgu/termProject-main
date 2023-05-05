package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMainController {


    @GetMapping("/")
    public String rootPage() {
        return "mainPage";
    }


}
