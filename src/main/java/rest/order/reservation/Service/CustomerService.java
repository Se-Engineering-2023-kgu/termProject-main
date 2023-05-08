package rest.order.reservation.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.DTO.Customer.CustomerRequestDTO;
import rest.order.reservation.Model.DTO.Customer.CustomerUpdateDTO;
import rest.order.reservation.Model.User.AppUser;
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

    UserClass userClass;

    public CustomerService(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }


    //    .... 50번이 나가는 건가..?? workBanch에서 엄청 많이 증가
    public Long addCustomer(CustomerRequestDTO request) {
        Customer customer = new Customer(
                null,
                request.loginId(),
                request.loginPwd(),
                request.name(),
                request.phoneNumber(),
                request.email(),
                UserClass.guest
                
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

    @Transactional
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
