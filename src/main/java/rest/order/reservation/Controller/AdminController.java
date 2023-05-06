package rest.order.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.order.reservation.Model.DTO.TableDTO;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Service.TableService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final TableService tableService;

    public AdminController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/adminMain")
    public String adminMain() {
        return "admin/adminMainPage";
    }

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


}
