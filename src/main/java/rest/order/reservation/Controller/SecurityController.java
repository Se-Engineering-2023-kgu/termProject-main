package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/cookie")
public class SecurityController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/userinfo")
    public String getUserInfo() {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        String username = null;
        for (Cookie cookie : cookies) {
            
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
                break;
            }
        }
        
        if (username != null) {
            // User information found in the cookie
            // Process the information as needed
            return "User: " + username;
        } else {
            // User information not found in the cookie
            // Handle the case accordingly
            return "User information not available";
        }
    }
}

/* 
 * 현재로선 시큐리티 부분을 위한 별도의 컨트롤러는 필요하지 않고 
 * 기존 유저 페이지 컨트롤러에서 그대로 반영해도 될 것으로 보임 
 * 
 * 부활: 쿠키 정보 불러오는 용도로 테스트해서 만드는 컨트롤러로 사용 
 */