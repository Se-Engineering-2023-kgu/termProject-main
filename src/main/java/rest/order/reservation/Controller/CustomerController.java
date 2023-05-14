package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String customer(@PathVariable Long id) {
        return "redirect:/customer/{id}/main";
    }

    @GetMapping("/{id}/main")
    public String customerMain(@PathVariable Long id, Model model) {
        AppUserDTO appUserDTO = customerService.findUser(id);
        
        model.addAttribute("userinfo", appUserDTO);
        return "customer/customerMainPage";
    }

    //회원 수정
    @GetMapping("/{id}/modify")
    public String getModifyCustomer(@PathVariable Long id, Model model) {
        AppUserDTO appUserDTO = customerService.findUser(id);
        model.addAttribute("appUser", appUserDTO);
        return "customer/customerModifyPage";
    }
    @PostMapping("/{id}/modify")
    public String modifyCustomer(@PathVariable Long id, @ModelAttribute("customer") AppUserDTO appUserDTO) {
    customerService.modify(id, appUserDTO);
    return "redirect:/customer/{id}/main";
}
    //회원 삭제
    @GetMapping("/{id}/delete")
    public String getDeleteCustomer(@PathVariable Long id, Model model) {
    AppUserDTO appUserDTO = customerService.findUser(id);
    model.addAttribute("userinfo", appUserDTO);
    return "customer/customerDeletePage";
}

    @PostMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
    customerService.deleteUser(id);
    return "redirect:/login";
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
