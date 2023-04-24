package rest.order.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import rest.order.Model.Menu;
import rest.order.Service.MenuService;


@Controller
@RequestMapping(path="/") 
public class WebMainController {
    // @Autowired
    // private 
    MenuService mService;

    @GetMapping("/greeting")
	public String rootPage(HttpServletRequest request) {
		return "greeting";
	}

    @GetMapping("/hello")
	public String helloPage(HttpServletRequest request) {
        System.out.println(mService.menuName());
        return "hello";
	}

}
