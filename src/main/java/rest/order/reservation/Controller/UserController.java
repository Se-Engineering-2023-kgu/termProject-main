package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Repository.ReservationRepo;
import rest.order.reservation.Service.UserService;

import rest.order.reservation.Service.ReservationService;
import java.security.Principal;
import java.util.List;
import rest.order.reservation.Model.Reservation;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ReservationService reservationService;

    @Autowired
    public UserController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
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

    

}

