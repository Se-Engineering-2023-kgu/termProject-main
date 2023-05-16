package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    UserService customerService;

    public CustomerController(UserService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public String customer(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "redirect:/customer/{id}/main";
    }

    @GetMapping("/{id}/main")
    public String customerMain(@PathVariable Long id, Model model) {
        AppUserDTO appUserDTO = customerService.findUser(id);

        model.addAttribute("user", appUserDTO);
        return "customer/customerMainPage";
    }



        /*
     * Security login
     * 
     */
    @RequestMapping("/login")
    public String loginString() {
        return "/customer/customerlogin";
    }

    @RequestMapping("/login?error=true")
    public String loginError(Model model) {
        model.addAttribute(null, model);
        return "/customer/customerlogin";
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
