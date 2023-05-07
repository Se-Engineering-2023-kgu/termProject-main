package rest.order.reservation.Model.DTO.Customer;

public record CustomerDTO(
        String loginId,
        String loginPwd,
        String name,
        String phoneNumber,
        String email

) {

}