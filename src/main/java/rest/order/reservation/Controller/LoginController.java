package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rest.order.reservation.DefineEnum.UserClass;
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
        return "user/loginPage";
    }

    /*
     * 로그인 postMapping을 스프링 시큐리티의 기능으로 들어감
     * 
     */

    // @PostMapping("/login")
    // public String login(@RequestParam String loginId, @RequestParam String
    // loginPwd,
    // RedirectAttributes redirectAttributes) {
    // System.out.println("loginId = " + loginId);
    // System.out.println("loginPwd = " + loginPwd);

    // AppUserDTO user = userService.loginCheck(loginId, loginPwd);
    // System.out.println("user = " + user);

    // if (user == null)
    // return "user/loginPage";

    // if (user.userType() == UserClass.admin) {
    // // redirectAttributes.addAttribute("adminId", user.uid());
    // System.out.println("관리자 입니다.");
    // return "redirect:/admin";
    // }
    // // 로그인 시도하는 appUser 가 admin 타입이라면?
    // // if (user.menuType() == UserClass.admin)
    // // model.addAttribute("id",user.uid());
    // // return "admin/adminMainPage";

    // // 로그인 시도하는 appUser가 customer 타입이라면?

    // redirectAttributes.addAttribute("id", user.uid());
    // return "redirect:/customer/{id}";
    // }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

}
