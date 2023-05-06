package rest.order.reservation.Model.DTO.customer;

public record CustomerUpdateDTO(
        String loginPwd,
        String phoneNumber,
        String email
) {
}
