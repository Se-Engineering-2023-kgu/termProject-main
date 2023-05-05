package rest.order.reservation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Model.DTO.MenuRequestDTO;
import rest.order.reservation.Service.MenuService;

public class MenuController {

    @Autowired
    MenuService menuService;


    //menuDTO에 정의된 데이터만 가져오도록 설정
    @GetMapping("menu/list/{id}")
    public String viewMenuEntity(@RequestParam long id, Model model) {
        MenuDTO menuDTO = menuService.viewMenu(id);
        model.addAttribute("menu", menuDTO);
        return "examples/MenuInformation";
        
    }

    //MenuRequestDTO 형식으로 요청을 받아서 메뉴서비스에 메뉴 추가함 
    // Menu에 비어있는 부분은 null 이 되거나, 따로 지정한 기본 값으로 들어가게됨 
    @PostMapping("menu/add")
    public ResponseEntity<?> addMenu(@ModelAttribute("menuRequest") MenuRequestDTO menuRequest) {
        MenuRequestDTO responseRequestDTO = menuService.addMenu(menuRequest);
        return ResponseEntity.ok(responseRequestDTO.toString());
    }

    //menuPage 만들어야함 적당한 post 형태의 submit 필요 
    @GetMapping("menu/add")
    public String menuAddPage(Model model) {
        model.addAttribute("menuRequest", new MenuRequestDTO("","", 0L, MenuType.NONE));
        return "examples/menuaddPage";
    }

    @PostMapping("menu/edit/{id}")
    public ResponseEntity<?> editMenu(@ModelAttribute("menuRequest") MenuDTO menuRequest, @PathVariable Long id) {
        MenuDTO responseRequestDTO = menuService.editMenu(menuRequest);
        return ResponseEntity.ok(responseRequestDTO.toString() + "Edit complete! ");
    }

    @GetMapping("menu/delete")
    public String menuDeletePage(Model model) {
        List<Menu> menulist = menuService.findAllMenu();
        model.addAttribute("menu", menulist);
        return "examles/menudeletePage";
    }
    //page 내보내는 건 List 화 되어있어서 다룰 때 약간 어려워 보임 

    @GetMapping(value="menu/delete/{id}")
    public String getMethodName(@RequestParam Long id) {
        menuService.deleteMenu(id);
        return "examles/menudeletePage";
    }
    
}
