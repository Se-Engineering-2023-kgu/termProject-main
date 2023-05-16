//package rest.order.reservation.Service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import rest.order.reservation.Model.DTO.Customer.CustomerRequestDTO;
//import rest.order.reservation.Model.DTO.Customer.CustomerUpdateDTO;
//import rest.order.reservation.Model.User.Customer;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@Transactional
//class CustomerServiceTest {
//
//    @Autowired
//    CustomerService customerService;
//
//    @Test
//    void addCustomer() {
//        CustomerRequestDTO cdto = new CustomerRequestDTO("12", "12", "12", "12", "12");
//        Long id = customerService.addCustomer(cdto);
//        Customer customer = customerService.viewCustomer(id);
//        assertEquals(id, customer.getUid());
//    }
//
//    @Test
//    void deleteCustomer() {
//        CustomerRequestDTO crdto = new CustomerRequestDTO("11", "11", "11", "11", "11");
//        Long id = customerService.addCustomer(crdto);
//        Customer customer = customerService.viewCustomer(id);
//        customerService.deleteCustomer(id);
////        assertEquals();
//    }
//
//    @Test
//    void modifyCustomer() {
//        CustomerRequestDTO crdto = new CustomerRequestDTO("11", "11", "11", "11", "11");
//        Long id = customerService.addCustomer(crdto);
//        System.out.println("crdto : " + crdto.toString());
//        CustomerUpdateDTO cudto = new CustomerUpdateDTO("22", "22", "22");
//
//        Customer customer = customerService.viewCustomer(id);
//        System.out.println("before customer : " + customer.toString());
//        System.out.println("before customer id : " + customer.getUid());
//        System.out.println("before customer loginId : " + customer.getLoginId());
//        System.out.println("before customer loginPwd : " + customer.getLoginPwd());
//
//        customer.chageCustomerInfo(cudto.loginPwd(), cudto.phoneNumber(), cudto.email());
//        System.out.println("after customer :" + customer.toString());
//        System.out.println("after customer id : " + customer.getUid());
//        System.out.println("after customer loginId : " + customer.getLoginId());
//        System.out.println("after customer loginPwd : " + customer.getLoginPwd());
//
//        assertEquals(customer.getUid(), id);
//        assertEquals(customer.getLoginId(), crdto.loginId());
//        assertEquals(customer.getPhoneNumber(), "22");
//    }
//
//
//}