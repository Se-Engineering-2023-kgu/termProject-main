package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.customer.CustomerRequestDTO;
import rest.order.reservation.Model.DTO.customer.CustomerUpdateDTO;
import rest.order.reservation.Model.User.Customer;
import rest.order.reservation.Repository.CustomerRepo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class CustomerService {


    private final CustomerRepo customerRepository;
//    private final CustomerDTOMapper customerDTOMapper;
//

    public CustomerService(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long addCustomer(CustomerRequestDTO request) {
        Customer customer = new Customer(
                request.loginId(),
                request.loginPwd(),
                request.name(),
                request.phoneNumber(),
                request.email()
        );
        customerRepository.save(customer);
        return customer.getUid();
    }

    public Customer viewCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        Stream<Customer> customerStream = StreamSupport.stream(customers.spliterator(), false);
        List<Customer> customerList = customerStream.collect(Collectors.toList());
        return customerList;
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
    }

    //더티 체킹
    // customer 내부 변환 메소드
    @Transactional
    public void modify(Long id, CustomerUpdateDTO update) {
        Customer customer = customerRepository.findById(id).get();
        customer.chageCustomerInfo(update.loginPwd(), update.phoneNumber(), update.email());
    }


//    public List<CustomerDTO> getAllCustomers() {
//        Iterable<Customer> customers = customerRepository.findAll();
//        Stream<Customer> customerStream = StreamSupport.stream(customers.spliterator(), false);
//        List<CustomerDTO> customerList = customerStream
//                .map(customer -> customerDTOMapper.apply(customer))
//                .collect(Collectors.toList());
//        return customers;
//    }


//    public Customer addCustomer(CustomerRequestDTO request) {
//        Customer customer = new Customer(
//                request.loginId(),
//                request.loginPwd(),
//                request.name(),
//                request.phoneNumber(),
//                request.email()
//        );
//        customerRepository.save(customer);
//        return customer;
//    }


//    public CustomerDTO viewCustomer(CustomerInfo customerInfo) {
//        Optional<Customer> customer = customerRepository.findById(customerInfo.id());
//
//        if (customer.isPresent()) {
//            CustomerDTO customerDTO = customerDTOMapper.apply(customer.get());
//            return customerDTO;
//        } else {
//            throw new RuntimeException("Customer not found with id: " + customerInfo.id());
//        }
//
//    }

//


}
