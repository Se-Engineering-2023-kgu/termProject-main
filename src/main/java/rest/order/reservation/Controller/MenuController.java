package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;


    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @ModelAttribute("menuTypes")
    public MenuType[] menuTypes() {
        return MenuType.values();
    }

    @GetMapping("/enroll")
    public String enrollMenuForm(Model model) {
        model.addAttribute("menu", new MenuDTO());

        return "menu/enrollMenuForm";
    }

    @PostMapping("/enroll")
    public String enrollMenu(MenuDTO menu) {
        menuService.addMenu(menu);
        return "redirect:/";
//        return "menu/enrollMenuForm";
    }


}
