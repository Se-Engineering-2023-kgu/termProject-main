//package rest.order.reservation.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import rest.order.reservation.Model.DTO.customer.CustomerRegistForm;
//import rest.order.reservation.Model.DTO.customer.CustomerRequestDTO;
//import rest.order.reservation.Service.CustomerService;
//
//
//@Controller
//@RequestMapping("customer")
//public class UserController {
//
//    private final CustomerService customerService;
//
//    public UserController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/enroll")
//    public String enrollMenuForm(Model model) {
//        model.addAttribute("customer", new CustomerRegistForm());
//
//        return "customer/registerForm";
//    }
//
//    @PostMapping("/enroll")
//    public String enrollMenu(@ModelAttribute("customer") CustomerRequestDTO customerRequest, BindingResult result) {
//        customerService.addCustomer(customerRequest);
//        return "redirect:/";
//    }
//
//
//}
