package rest.order.reservation.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.AppUser.UserRegistForm;
import rest.order.reservation.Service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUser() {
        // Given
        UserRegistForm userRegistForm = new UserRegistForm("john123", "password", "John Doe", UserClass.customer, "123456789", "john.doe@example.com");
        Long userId = userService.addUser(userRegistForm);

        // When
        AppUserDTO appUserDTO = userService.findUser(userId);

        // Then
        assertEquals(userId, appUserDTO.uid());
        assertEquals("john123", appUserDTO.loginId());
        assertEquals("John Doe", appUserDTO.name());
        assertEquals(UserClass.customer, appUserDTO.userType());
        assertEquals("123456789", appUserDTO.phonNumber());
        assertEquals("john.doe@example.com", appUserDTO.email());
    }

    @Test
    public void testDeleteUser() {
        // Given
        UserRegistForm userRegistForm = new UserRegistForm("john123", "password", "John Doe", UserClass.customer, "123456789", "john.doe@example.com");
        Long userId = userService.addUser(userRegistForm);

        // When
        userService.deleteUser(userId);

        // Then
        AppUserDTO appUserDTO = userService.findUser(userId);
        assertNull(appUserDTO);
    }

    @Test
    public void testModifyUser() {
        // Given
        UserRegistForm userRegistForm = new UserRegistForm("john123", "password", "John Doe", UserClass.customer, "123456789", "john.doe@example.com");
        Long userId = userService.addUser(userRegistForm);

        // When
        AppUserDTO updatedUserDTO = new AppUserDTO(userId, "john123", "newpassword", "John Doe", UserClass.customer, "987654321", "john.doe@example.com");
        userService.modify(userId, updatedUserDTO);

        // Then
        AppUserDTO appUserDTO = userService.findUser(userId);
        assertEquals("newpassword", appUserDTO.loginPwd());
        assertEquals("987654321", appUserDTO.phonNumber());
    }

    @Test
    public void testLoginCheck() {
        // Given
        UserRegistForm userRegistForm = new UserRegistForm("john123", "password", "John Doe", UserClass.customer, "123456789", "john.doe@example.com");
        Long userId = userService.addUser(userRegistForm);

        // When
        AppUserDTO appUserDTO = userService.loginCheck("john123", "password");

        // Then
        assertEquals(userId, appUserDTO.uid());
        assertEquals("john123", appUserDTO.loginId());
        assertEquals("John Doe", appUserDTO.name());
        assertEquals(UserClass.customer, appUserDTO.userType());
        assertEquals("123456789", appUserDTO.phonNumber());
        assertEquals("john.doe@example.com", appUserDTO.email());
    }
}

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