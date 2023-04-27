package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Service.MenuService;


@Controller
public class WebMainController {

    @Autowired
    MenuService mService;

    @GetMapping("/")
    public String rootPage() {
        return "hi";
    }

    @GetMapping("/user")
    public String helloPage(Model model) {
        model.addAttribute("userinfo", "thymeleaf");
        System.out.println(mService.menuName());
        return "usertemp";
    }

    @GetMapping("/good")
    public String uploadString(@ModelAttribute AppUser uri, HttpServletRequest request) {
        return "greeting";
    }

}
