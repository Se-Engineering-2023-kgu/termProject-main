package rest.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import rest.order.Model.AppUser;
import rest.order.Repository.UserRepo;
import rest.order.Service.UserService;
@Controller
@RequestMapping(path = "/")
public class UserController {
    // @Autowired

    private UserRepo userRepo;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String nickName,@RequestParam String loginID, @RequestParam String passWD){

    }
}
