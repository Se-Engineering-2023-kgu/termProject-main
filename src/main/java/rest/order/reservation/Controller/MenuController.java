package rest.order.reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

//    @ModelAttribute("menuType")
//    public Map<MenuType, String> menuType() {
//        Map<MenuType, String> menuTypeMap = new HashMap<>();
//        menuTypeMap.put(MenuType.Appetizers, "Appetizers");
//        menuTypeMap.put(MenuType.Desert, "Desert");
//        menuTypeMap.put(MenuType.Beverage, "Beverage");
//        menuTypeMap.put(MenuType.MainCuisine, "MainCuisine");
//        return menuTypeMap;
//    }

    @GetMapping("/enroll")
    public String enrollMenuForm(Model model) {
        model.addAttribute("menu", new MenuDTO());
        return "menu/enrollMenuForm";
    }

    @PostMapping("/enroll")
    public String enrollMenu(MenuDTO menu) {
        menuService.addMenu(menu);
        return "redirect:/";
    }


}
