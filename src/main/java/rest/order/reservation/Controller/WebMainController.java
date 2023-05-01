package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Service.MenuService;
import rest.order.reservation.Service.TableService;

@Controller
public class WebMainController {

    @Autowired
    MenuService menuService;

    @Autowired
    TableService tService;

    @GetMapping("/")
    public String rootPage() {
        return "hi";
    }

    @GetMapping("/menu")
    public String menuPage(Model mode) {
        return "menupage";
    }

    @PostMapping("/menu/menuaddd")
    public String menuadd() {

        mService.addMenu();// 메뉴 아이디, 이름, 단가, 등등등
        // 수행하면 menu DB 에 메뉴 등록

        return "menulist";

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
