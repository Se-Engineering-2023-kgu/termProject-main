package rest.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ui.Model;

import rest.order.Model.Menu;
import rest.order.Service.MenuService;

@Controller
public class MainController {
    // @Autowired
    // private
    MenuService mService;

    @GetMapping("/")
    public String rootPage(Model model) {
        model.addAttribute("greeting", "greeting");
        return "greeting";
    }

    @GetMapping("/user")
    public String helloPage(Model model) {
        model.addAttribute("userinfo", "thymeleaf");
        System.out.println(mService.menuName());
        return "usertemp";
    }

    @GetMapping("/good")
    public String goodreturn() {
        return "index";
    }

}
