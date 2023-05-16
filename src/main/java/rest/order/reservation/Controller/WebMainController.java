package rest.order.reservation.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMainController {


    @GetMapping("/")
    public String rootPage() { // 세션을 기준으로 "/" 를  판단해야하나?
//        log.info("메인페이지 접근");
        // 로그인x 세션 x  redirect:/ --> guest 페이지
        return "mainPage";

        // 로그인 o 세션 o redirect:/ --> customer , admin  페이지

        //           user 타입 customer
        //                return "customer/customerMainPage"
        //           user 타입 admin
        //                  return "admin/adminMainPage";
    }


}
