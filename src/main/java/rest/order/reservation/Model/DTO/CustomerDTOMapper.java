package rest.order.reservation.Model.DTO;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import rest.order.reservation.Model.User.Customer;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer customer) {
        // TODO Auto-generated method stub
        return new CustomerDTO(
            customer.getUid(),
            customer.getName(),
            customer.getPhoneNumber(),
            customer.getEmail(),
            customer.getUserType()
        );
    }

}
