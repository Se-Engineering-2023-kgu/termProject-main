package rest.order.reservation.Controller;


import groovy.util.logging.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rest.order.reservation.DefineEnum.MenuType;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.DTO.TableDTO;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.AppUserSearch;
import rest.order.reservation.Service.MenuService;
import rest.order.reservation.Service.ReservationService;
import rest.order.reservation.Service.TableService;
import rest.order.reservation.Service.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {


    private final TableService tableService;
    private final MenuService menuService;
    private final ReservationService reservationService;
    private final UserService userService;


    public AdminController(TableService tableService, MenuService menuService, ReservationService reservationService, UserService userService) {
        this.tableService = tableService;
        this.menuService = menuService;
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @ModelAttribute("menuTypes")
    public MenuType[] menuTypes() {
        return MenuType.values();
    }

    @GetMapping
    public String admin() {
        return "redirect:/admin/main";
    }

    @GetMapping("/main")
    public String adminMain(Model model) {

        List<Reservation> reservationList = reservationService.findAllReservation(new ReservationSearch(LocalDate.now()));

        Map<String, Integer> reservationMap = new HashMap<>();
        for (Reservation reservation : reservationList) {
            String key = reservation.getTimeSlot().getDetail();
            reservationMap.put(key, reservationMap.getOrDefault(key, 0) + 1);
        }
        model.addAttribute("reservationMap", reservationMap);
        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("reservationCount", reservationList.size());

        return "admin/adminMainPage";
    }


    //테이블 등록
    @GetMapping("/table")
    public String addTableForm(Model model) {
        model.addAttribute("table", new TableDTO());
        return "admin/addTablePage";
    }

    @PostMapping("/table")
    public String addMenu(@ModelAttribute("tableRequest") TableDTO tableRequest) {
        tableService.addTable(tableRequest);
//        return ResponseEntity.ok(responseRequestDTO.toString());
        return "redirect:/admin";
    }

//    @GetMapping("/reservationList")
//    public String reservationList(Model model) {
//        List<Reservation> reservationList = reservationService.findAllReservation();
//        model.addAttribute("reservationList", reservationList);
//        return "admin/reservationList";
//    }

    @GetMapping("/reservationList")
    public String reservationSearch(@ModelAttribute("researvationSearch") ReservationSearch reservationSearch, Model model) {
//        List<Reservation> reservationList = reservationService.findAllReservation();
        System.out.println("여기까지는 오나?");
        List<Reservation> reservationList = reservationService.findAllReservation(reservationSearch);

        model.addAttribute("reservationList", reservationList);
        return "admin/reservationList";
    }

    @GetMapping("/customerList")
    public String CustomerSearch(@ModelAttribute("appUserSearch") AppUserSearch appUserSearch, Model model) {

        List<AppUser> appUserList = userService.findAllUser(appUserSearch);
        model.addAttribute("appUserList", appUserList);
        return "admin/manageCustomerPage";
    }
    //    @GetMapping("/customer")
//    public String manageUser(Model model) {
//        return "customerList";
//    }


    // 메뉴 등록 부분은, 메뉴 컨트롤러가 진행하고, 메뉴 컨트롤러에서 인증 절차를 통해 접근을 진행해야 합니다.
    // 이와 관련해선 spring Security를 참고

    @GetMapping("/menu")
    public String addMenuForm(Model model) {
        model.addAttribute("menu", new MenuRegistForm(null, null, null, null));
        List<Menu> menuList = menuService.findAllMenu();
        model.addAttribute("menuList", menuList);
        return "admin/addMenuPage";
    }

    @PostMapping("/menu")
    public String addMenu(MenuRegistForm menu) {
        menuService.addMenu(menu);
        return "redirect:/admin";
    }


    @DeleteMapping("reservation/delete/{reservationId}")
    @ResponseBody
    public ResponseEntity<?> reservationDelete(@PathVariable("reservationId") Long id) {
//        log.info("delete 까지는 왔다");
        try {
            reservationService.deleteReservation(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("customer/delete/{uid}")
    public ResponseEntity<?> customerDelete(@PathVariable("uid") Long id) {
        try {
            // 유저 id 넣어서 -> reservation들 모두 찾고 -> 모두 삭제
            List<Reservation> reservationList = reservationService.getReservationsByCustomerId(id);
            for (Reservation reservation : reservationList) {
                reservationService.deleteReservation(reservation.getReservationID());
            }
            // 유저 삭제
            userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    // 메뉴는 에약에 참조키, 삭제불가능
//     @DeleteMapping("reservation/delete/{mid}")
//     @ResponseBody
//     public ResponseEntity<?> reservationDelete(@PathVariable("reservationId") Long id) {
// //        log.info("delete 까지는 왔다");
//         try {
//             reservationService.deleteReservation(id);
//             return new ResponseEntity(HttpStatus.OK);
//         } catch (RuntimeException e) {
//             return new ResponseEntity(HttpStatus.BAD_REQUEST);
//         }

//     }


}
