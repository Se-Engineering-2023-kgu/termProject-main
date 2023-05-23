package rest.order.reservation.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        if (authentication != null && authentication.isAuthenticated()){
            System.out.println("get userDTO");
        AppUserDTO userDTO = userService.getPrincipalToUserDTO(authentication);
        }
        /*
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getPrincipal() instanceof AppUser) {
            {
                AppUser userDetails = (AppUser) authentication.getPrincipal();
                // userDetails.findById
                // AppUserDTO appUserDTO = userDetails.getLoginId();

                AppUserDTO appUserDTO = userService.getCurrentUser();

                if (appUserDTO != null) {
                    model.addAttribute("user", appUserDTO);
                }
            }
            if (userService.getCurrentUser() == null) {
                // User not logged in, redirect to guest page
                return "mainPage";
            } else {
                if (userService.isAdminUser()) {
                    // Admin user, redirect to admin page
                    return "admin/adminMainPage";
                } else {
                    // Customer user, redirect to customer page
                    return "customer/customerMainPage";
                }
            }
        }
         */
        return "mainPage";

        // 로그인 o 세션 o redirect:/ --> customer , admin 페이지

        // user 타입 customer
        // return "customer/customerMainPage"
        // user 타입 admin
        // return "admin/adminMainPage";

    }
}