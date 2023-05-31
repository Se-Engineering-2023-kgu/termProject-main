package rest.order.reservation.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.User.AppUserRepo;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final AppUserRepo AppUserRepository;

    public EmailService(JavaMailSender mailSender, AppUserRepo AppUserRepository) {
        this.mailSender = mailSender;
        this.AppUserRepository = AppUserRepository;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void reservationMail() {
        
    }

    public void sendReservationEamil(Long id, ReservationForm reservation) {
        AppUser appUser = AppUserRepository.findById(id).get();
        AppUserDTO appUserDTO =  AppUserDTO.form(appUser);

        String userMail = appUserDTO.email().toString();



        sendEmail(userMail, reservation.getDate() + " " + reservation.getTime().getDetail() + " 예약 주문 ", reservation.toString());
    }
}