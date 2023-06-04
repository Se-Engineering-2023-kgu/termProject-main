package rest.order.reservation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.order.reservation.Service.EmailService;

@RestController
public class MailController {
    
    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // @GetMapping("/send-email")
    // public String sendEmail() {
    //     String to = "choi4624@gmail.com";
    //     String subject = "Test Email";
    //     String body = "This is a test email.";

        

    //     emailService.sendEmail(to, subject, body);

    //     return "emailSentPage";
    // }

}
