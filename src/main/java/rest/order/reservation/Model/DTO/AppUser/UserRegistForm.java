package rest.order.reservation.Model.DTO.AppUser;

import rest.order.reservation.DefineEnum.UserClass;

public record UserRegistForm(

                String loginId,

                String loginPwd,

                String name,

                UserClass userType,

                String phoneNumber,

                String email

// UserClass userType

) {

        public String loginPwd(String encode) {
                return encode;
        }

}
