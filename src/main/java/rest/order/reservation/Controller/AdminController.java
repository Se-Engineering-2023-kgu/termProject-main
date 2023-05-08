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
        tableService.addTable(tableRequest);
//        return ResponseEntity.ok(responseRequestDTO.toString());
        return "redirect:/admin/adminMain";
    }


    // 메뉴 등록 부분은, 메뉴 컨트롤러가 진행하고, 메뉴 컨트롤러에서 인증 절차를 통해 접근을 진행해야 합니다. 
    // 이와 관련해선 spring Security를 참고 

    @GetMapping("/menu/add")
    public String addMenuForm(Model model) {
        model.addAttribute("menu", new MenuRegistForm(null, null, null, null));

        return "admin/addMenuForm";
    }

    @PostMapping("/menu/add")
    public String addMenu(MenuRegistForm menu) {
        menuService.addMenu(menu);
        return "redirect:/";

    }


}
