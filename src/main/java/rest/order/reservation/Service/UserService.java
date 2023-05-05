package rest.order.reservation.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.DTO.CustomerDTO;
import rest.order.reservation.Model.DTO.CustomerDTOMapper;
import rest.order.reservation.Model.DTO.CustomerInfo;
import rest.order.reservation.Model.DTO.CustomerRegisteration;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.Customer;
import rest.order.reservation.Repository.CustomerRepo;


@Service
public class UserService {

    @Autowired
    private final CustomerRepo customerRepository;
    private final CustomerDTOMapper customerDTOMapper;

    public UserService(CustomerRepo customerRepository, CustomerDTOMapper customerDTOMapper) {
        this.customerRepository = customerRepository;
        this.customerDTOMapper = customerDTOMapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        Stream<Customer> customerStream = StreamSupport.stream(customers.spliterator(), false);
        List<CustomerDTO> customerList = customerStream
                                        .map(customer -> customerDTOMapper.apply(customer))
                                        .collect(Collectors.toList());
        return customerList;
            
    }

    public void addCustomer(CustomerRegisteration registerationrequest) {
        Customer customer = new Customer( 
            registerationrequest.loginId(), 
            registerationrequest.loginPwd(), 
            registerationrequest.name(), 
            registerationrequest.phoneNumber(), 
            registerationrequest.email(), 
            registerationrequest.userType());
        customerRepository.save(customer);
    }

    public CustomerDTO viewCustomer(CustomerInfo customerInfo) {
        Optional<Customer> customer = customerRepository.findById(customerInfo.id());

        if(customer.isPresent()){
            CustomerDTO customerDTO = customerDTOMapper.apply(customer.get());
            return customerDTO;
        }
        else{
            throw new RuntimeException("Customer not found with id: " + customerInfo.id());
        }
        
    }

    public void deleteCustomer() {
        
    }

}
