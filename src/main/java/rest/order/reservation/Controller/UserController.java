package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.Customer.CustomerRegistForm;
import rest.order.reservation.Model.DTO.Customer.CustomerRequestDTO;
import rest.order.reservation.Service.UserService;


@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String customerRegister(Model model) {
        model.addAttribute("customer", new CustomerRegistForm(null, null, null, null, null));
        return "/customer/registerForm";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") CustomerRequestDTO request, BindingResult result) {
        System.out.println("request : " + request);
        userService.addCustomer(request);
        return "redirect:/";
    }


}
