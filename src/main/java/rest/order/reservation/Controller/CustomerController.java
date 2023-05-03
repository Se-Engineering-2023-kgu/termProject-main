package rest.order.reservation.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import rest.order.reservation.Model.DTO.CustomerDTO;

public class CustomerController {
    
    

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return null; 
        
    }

}
