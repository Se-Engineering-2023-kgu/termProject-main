package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.customer.CustomerRegistForm;
import rest.order.reservation.Model.DTO.customer.CustomerRequestDTO;
import rest.order.reservation.Service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String customerRegister(Model model) {
        model.addAttribute("customer", new CustomerRegistForm());
        return "/customer/registerForm";
    }

    @PostMapping("/register")
    public String registerCustomer(@Validated @ModelAttribute("customer") CustomerRequestDTO request, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/customer/register"; // 수정
//        }
        System.out.println("request : " + request);
        customerService.addCustomer(request);
//        return ResponseEntity.ok()
//                .build();
        return "redirect:/";
    }


//    @GetMapping("/list")
//    public String list(Model model) {
//        List<Customer> customerList = customerService.getAllCustomers();
//        model.addAttribute("customerList", members);
//        return "members/memberList";
//    }


//    @GetMapping("customer/{id}")
//    public String viewCustomer(@PathVariable Long id, Model model) {
//        CustomerInfo customerInfo = new CustomerInfo(id);
//        CustomerDTO customer = userService.viewCustomer(customerInfo);
//        model.addAttribute("customer", customer);
//        return "examples/customerInformation";
//    }

//    @PostMapping("/register")
//    public String registerCustomer(@Validated CustomerRegistForm request, BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/customer/register"; // 수정
//        }
//
//        System.out.println("request : " + request);
//        customerService.addCustomer(request);
//        return "redirect:/";
////        return ResponseEntity.ok()
////                .build();
//    }
//    @GetMapping
//    public List<CustomerDTO> getCustomers() {
//        return userService.getAllCustomers();
//
//    }


}
