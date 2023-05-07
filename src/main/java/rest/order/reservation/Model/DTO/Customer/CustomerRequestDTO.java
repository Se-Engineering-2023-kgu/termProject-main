package rest.order.reservation.Model.DTO.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(
        @NotBlank String loginId,
        @NotBlank String loginPwd,
        @NotBlank String name,
        @NotBlank String phoneNumber,
        @Email String email

) {

}