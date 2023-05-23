package rest.order.reservation.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Service.UserService;

@Controller
public class WebMainController {

    private final UserService userService;

    public WebMainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String rootPage(Model model) {

        System.out.println("get auth");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication);

        if (authentication.getPrincipal().equals("anonymousUser") ) {
            return "mainPage";
        }

        if (authentication != null && authentication.isAuthenticated()){
            System.out.println("get userDTO");
        AppUserDTO userDTO = userService.getPrincipalToUserDTO(authentication);
            if (userDTO != null) {
                model.addAttribute("user", userDTO);
            }
            else{
                return "mainPage";
            }

            // 유저 정보를 가져와서 리턴
            if (userDTO.userType().equals(UserClass.admin)) {
                // Admin user, redirect to admin page
                return "admin/adminMainPage";
            } else {
                if (userDTO.userType().equals(UserClass.customer)) {
                     // Customer user, redirect to customer page
                    return "customer/customerMainPage";
                } else {
                    // may be somthing else, default page
                    // 게스트 인지를 구별해 줘야 하나? 
                    return "mainPage";
                    
                }
            }
        }
        
        return "mainPage"; 
    
    }
}