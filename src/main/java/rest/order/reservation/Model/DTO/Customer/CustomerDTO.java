//package rest.order.reservation.Model.DTO.Customer;
//
//import rest.order.reservation.Model.User.Customer;
//
//public record CustomerDTO(
//        String loginId,
//        // String loginPwd, 로그인 외에는 얘는 일반적으로 쓰이면 안될 것임
//        String name,
//        String phoneNumber,
//        String email
//
//) {
//
//        public static CustomerDTO CustomerDTOForm(Customer customer){
//                CustomerDTO customerDTO = new CustomerDTO(
//                                customer.getLoginId(),
//                                //customer.getLoginPwd(),
//                                customer.getName(),
//                                customer.getPhoneNumber(),
//                                customer.getEmail()
//                                );
//                return customerDTO;
//
//        }
//}