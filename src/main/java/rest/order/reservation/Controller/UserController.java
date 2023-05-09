//package rest.order.reservation.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
//import rest.order.reservation.Service.UserService;
//
//
//@Controller
//@RequestMapping("user")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//
//    }
//
//    @GetMapping("/enroll")
//    public String enrollMenuForm(Model model) {
////        model.addAttribute("user", new AppUserDTO());
//
//        return "signUpUser";
//    }
//
//    @PostMapping("/enroll")
//    public String enrollMenu(@ModelAttribute("user") @Validated AppUserDTO userForm, BindingResult result) {
////        if (result.hasErrors())
////            return "user/enrollUserForm";
//
//        return "user/userInfo";
//    }
//
//}
