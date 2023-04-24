package rest.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rest.order.Repository.CustomerRepo;
import rest.order.Model.Customer;
@Controller
@RequestMapping
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(path="/add")
    public @ResponseBody String addNewCustomer (@RequestParam String phoneNumberString
    ,@RequestParam String emailString,
    String customerNameString) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
       
        Customer n = new Customer(1 , customerNameString, customerNameString, customerNameString, customerNameString, customerNameString, customerNameString, null);
        customerRepo.save(n); // 새로 만든 customer를 db로 insert 
        return "Saved";
    }
    
}
