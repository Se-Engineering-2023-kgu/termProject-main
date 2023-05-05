package rest.order.reservation.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import rest.order.reservation.Model.DTO.CustomerDTO;
import rest.order.reservation.Model.DTO.CustomerInfo;
import rest.order.reservation.Model.DTO.CustomerRegisteration;
import rest.order.reservation.Model.User.Customer;
import rest.order.reservation.Service.UserService;

@Controller
public class CustomerController {
    
    UserService userService;
    

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return userService.getAllCustomers(); 
        
    }

    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegisteration request) {
        userService.addCustomer(request);
        return ResponseEntity.ok()
            .build();
        
    }

    @GetMapping("customer/{$id}")
    public String viewCustomer(@RequestParam Long id, Model model) {
        CustomerInfo customerInfo = new CustomerInfo(id);
        CustomerDTO customer = userService.viewCustomer(customerInfo);
        model.addAttribute("customer",customer);
        return "examples/customerInformation";
    }
}
