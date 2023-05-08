package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login/loginPage";
    }

//    @PostMapping("/login")
//    public String loginPage() {
//    }

}
