package rest.order.reservation.Model.DTO.customer;

public record CustomerDTO(
        String loginId,
        String loginPwd,
        String name,
        String phoneNumber,
        String email

) {

}