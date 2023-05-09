package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public String customer(@PathVariable Long id) {
        return "redirect:/customer/{id}/main";
    }

    @GetMapping("/{id}/main")
    public String customerMain(@PathVariable Long id) {
        return "customer/customerMainPage";
    }
    //    @GetMapping("customer/{id}")
//    public String viewCustomer(@PathVariable Long id, Model model) {
//
//        Customer customer = customerService.viewCustomer(id);
//        model.addAttribute("customer", customer);
//        return "customer/customerInfo";
//    }


    //회원 등록
//    @GetMapping("/register")
//    public String customerRegister(Model model) {
//        model.addAttribute("customer", new UserRegistForm(null, null, null, null, null));
//        return "/customer/registerForm";
//    }

//    @PostMapping("/register")
//    public String registerCustomer(@ModelAttribute("customer") CustomerRequestDTO request, BindingResult result) {
//        System.out.println("request : " + request);
//        customerService.addCustomer(request);
//        return "redirect:/";
//    }

    //회원 조회 -> id 있으면 admin에서 쓰는 것 아닐까?
//    @GetMapping("customer/{id}")
//    public String viewCustomer(@PathVariable Long id, Model model) {
//
//        Customer customer = customerService.viewCustomer(id);
//        model.addAttribute("customer", customer);
//        return "customer/customerInfo";
//    }

    // 회원 수정


    // 회원 삭제


}