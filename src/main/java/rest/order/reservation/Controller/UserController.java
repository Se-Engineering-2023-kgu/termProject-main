package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Service.UserService;


@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    // 회원가입
    @GetMapping("/register")
    public String customerRegister(Model model) {
        model.addAttribute("user", new UserRegistForm(null, null, null, null, null, null));
        return "user/registerPage";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("user") UserRegistForm request, BindingResult result) {
        System.out.println("request : " + request);
        userService.addUser(request);
        return "redirect:/";
    }

    // 로그인 페이지
//    @GetMapping("/login")
//    public String loginPage() {
//        return "user/loginPage";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String loginId, @RequestParam String loginPwd, RedirectAttributes redirectAttributes) {
//        System.out.println("loginId = " + loginId);
//        System.out.println("loginPwd = " + loginPwd);
//
//        AppUserDTO user = userService.loginCheck(loginId, loginPwd);
//        System.out.println("user = " + user);
//
//        if (user == null)
//            return "user/loginPage";
//
//        // 관리자
//        if (user.userType() == UserClass.admin) {
//            redirectAttributes.addAttribute("adminId", user.uid());
//            return "redirect:/admin";
//        }
//
//        //고객
//        redirectAttributes.addAttribute("id", user.uid());
//        return "redirect:/customer/{id}";
//    }


}
