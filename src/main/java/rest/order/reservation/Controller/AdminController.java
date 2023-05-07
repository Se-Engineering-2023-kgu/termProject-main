package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.DTO.TableDTO;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Service.MenuService;
import rest.order.reservation.Service.TableService;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final TableService tableService;
    private final MenuService menuService;


    public AdminController(TableService tableService, MenuService menuService) {
        this.tableService = tableService;
        this.menuService = menuService;
    }

    @ModelAttribute("menuTypes")
    public MenuType[] menuTypes() {
        return MenuType.values();
    }

    @GetMapping("/adminMain")
    public String adminMain() {
        return "admin/adminMainPage";
    }


    //테이블 등록
    @GetMapping("/addTable")
    public String addTableForm(Model model) {
        model.addAttribute("table", new TableDTO());
        return "admin/addTable";
    }

    @PostMapping("/addTable")
    public String addMenu(@ModelAttribute("tableRequest") TableDTO tableRequest) {
        TableList responseRequestDTO = tableService.addTable(tableRequest);
//        return ResponseEntity.ok(responseRequestDTO.toString());
        return "redirect:/admin/adminMain";
    }


    // 메뉴 등록
    @GetMapping("/addMenu")
    public String addMenuForm(Model model) {
        model.addAttribute("menu", new MenuRegistForm());

        return "admin/addMenuForm";
    }

    @PostMapping("/addMenu")
    public String addMenu(MenuRegistForm menu) {
        menuService.addMenu(menu);
        return "redirect:/";

    }


}
