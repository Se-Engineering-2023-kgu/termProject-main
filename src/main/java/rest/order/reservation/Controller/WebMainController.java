package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebMainController {
//    MenuService mService;

    @GetMapping("/")
    public String rootPage() {
        return "hi";
    }

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        System.out.println(mService.menuName());
//        return "";
//    }

}
