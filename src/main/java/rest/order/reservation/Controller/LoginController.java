package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login/loginPage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String loginPwd) {
        System.out.println("loginId = " + loginId);
        System.out.println("loginPwd = " + loginPwd);
        return "redirect:/";
    }

//    @PostMapping("/login")
//    public String loginPage() {
//    }

}
