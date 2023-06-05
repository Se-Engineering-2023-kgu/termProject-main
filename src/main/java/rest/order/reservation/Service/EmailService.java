package rest.order.reservation.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.User.AppUserRepo;



@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final AppUserRepo AppUserRepository;
    private final TemplateEngine templateEngine;
    private final MenuService menuService;

    public EmailService(JavaMailSender mailSender, AppUserRepo AppUserRepository, TemplateEngine templateEngine, MenuService menuService) {
        this.mailSender = mailSender;
        this.AppUserRepository = AppUserRepository;
        this.templateEngine = templateEngine;
        this.menuService = menuService;
    }

    public void sendEmail(String to, String subject, ReservationForm name, Long id) throws MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com"); 
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("bhchoi@kyonggi.ac.kr");
        helper.setTo(to);
        helper.setSubject(subject);

        List<Menu> menuList = new ArrayList<>();
        for (Long menuId : name.getOrderMenuList()) {
            Menu menu = menuService.findMenu(menuId);
            menuList.add(menu);
        }

        List<String> menuNames = new ArrayList<>();
        for (Menu menu : menuList) {
            menuNames.add(menu.getName());
        }
    
        Context context = new Context();
        context.setVariable("members", name.getMembers().toString());
        context.setVariable("date", name.getDate().toString());
        context.setVariable("detail", name.getTime().getDetail().toString());
        context.setVariable("tables", name.getTid().toString());
        context.setVariable("orderMenuList", menuNames);

        String htmlContent = templateEngine.process("reservation/reservationEmail", context);

        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

    public void reservationMail() {
        
    }

    public void sendReservationEamil(Long id, ReservationForm reservation) {
        AppUser appUser = AppUserRepository.findById(id).get();
        AppUserDTO appUserDTO =  AppUserDTO.form(appUser);

        
        String userMail = appUserDTO.email().toString();
        System.out.println("UserMAIL is " + userMail);

        try {
            sendEmail(userMail, reservation.getDate() + " " + reservation.getTime().getDetail() + " 예약 주문 ", reservation, id);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}