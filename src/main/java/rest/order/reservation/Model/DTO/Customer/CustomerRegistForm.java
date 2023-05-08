package rest.order.reservation.Model.DTO.Customer;

import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.User.Customer;

public record CustomerRegistForm (

    String loginId,

    String loginPwd,

    String name,

    String phoneNumber,

    String email

    // UserClass userType

    ){


        //    
        public static Customer registForm(CustomerRegistForm customerRegistForm) {
            Customer customer = new Customer( 
                customerRegistForm.loginId,
                customerRegistForm.loginPwd, 
                customerRegistForm.name, 
                customerRegistForm.phoneNumber, 
                customerRegistForm.email
                );
            return customer;
            
        }

}
