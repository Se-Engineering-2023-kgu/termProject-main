package rest.order.reservation.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Model.DTO.MenuRequestDTO;
import rest.order.reservation.Service.MenuService;

public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("menu/list/{id}")
    public String viewMenuEntity(@RequestParam long id, Model model) {
        MenuDTO menuDTO = menuService.viewMenu(id);
        model.addAttribute("menu", menuDTO);
        return "examples/MenuInformation";
        
    }

    @PostMapping("menu/add")
    public ResponseEntity<?> addMenu(@RequestBody MenuRequestDTO menuRequest) {
        
        MenuRequestDTO responseRequestDTO = menuService.addMenu(menuRequest);
        
        return ResponseEntity.ok(responseRequestDTO.toString());
    }

}
