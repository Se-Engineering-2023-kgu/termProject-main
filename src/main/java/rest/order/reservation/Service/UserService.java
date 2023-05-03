package rest.order.reservation.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.DTO.CustomerDTO;
import rest.order.reservation.Model.DTO.CustomerDTOMapper;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.Customer;
import rest.order.reservation.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private final UserRepo userRepository;
    private final CustomerDTOMapper customerDTOMapper;

    public UserService(UserRepo userRepository, CustomerDTOMapper customerDTOMapper) {
        this.userRepository = userRepository;
        this.customerDTOMapper = customerDTOMapper;
    }



    public List<CustomerDTO> getAllCustomers() {
        Iterable<Customer> customers = userRepository.findAll();
        Stream<Customer> customerStream = StreamSupport.stream(customers.spliterator(), false);
        List<CustomerDTO> customerList = customerStream
                                        .map(customer -> customerDTOMapper.apply(customer))
                                        .collect(Collectors.toList());
        return customerList;
            
    }

}
