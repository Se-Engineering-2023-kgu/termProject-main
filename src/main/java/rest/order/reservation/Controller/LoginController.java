package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login/loginPage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String loginPwd, Model model) {
        System.out.println("loginId = " + loginId);
        System.out.println("loginPwd = " + loginPwd);

        AppUserDTO user = userService.loginCheck(loginId, loginPwd);
        System.out.println("user = " + user);

        if (user == null)
            return "login/loginPage";

        //     로그인 시도하는 appUser 가 admin 타입이라면?
//       if (user.menuType() == UserClass.admin)
//            model.addAttribute("id",user.uid());
//           return "admin/adminMainPage";

//     로그인 시도하는 appUser가 customer 타입이라면?
//        if(user.menuType() == UserClass.customer)
//             model.addAttribute("id",user.uid());
//             return "/";

        System.out.println("user = " + user.name());
        return "redirect:/";
    }


}
