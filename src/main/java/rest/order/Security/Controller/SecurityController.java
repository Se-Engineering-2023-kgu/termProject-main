package rest.order.Security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/login")
public class SecurityController {

    @PostMapping("/trylogin")
    public ResponseEntity login() {
        return ResponseEntity.ok().body("cookie");

    }
}
