package rest.order.reservation.Model.DTO.customer;

import rest.order.reservation.Model.User.Customer;

import java.util.function.Function;

public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer customer) {

        return new CustomerDTO(
                customer.getLoginId(),
                customer.getLoginPwd(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getEmail()
        );
    }

}