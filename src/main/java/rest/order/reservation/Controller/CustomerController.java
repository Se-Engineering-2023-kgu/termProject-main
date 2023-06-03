package rest.order.reservation.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rest.order.reservation.Model.DTO.AppUser.AppUserDTO;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Service.MenuService;
import rest.order.reservation.Service.ReservationService;
import rest.order.reservation.Service.TableService;
import rest.order.reservation.Service.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final UserService customerService;

    private final ReservationService reservationService;

    private final TableService tableService;
    private final MenuService menuService;


    public CustomerController(UserService customerService, ReservationService reservationService, TableService tableService, MenuService menuService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
        this.tableService = tableService;
        this.menuService = menuService;
    }

    @GetMapping("/{id}")
    public String customer(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "redirect:/customer/{id}/main";
    }

    @GetMapping("/{id}/main")
    public String customerMain(@PathVariable Long id, Model model) {
        AppUserDTO appUserDTO = customerService.findUser(id);

        model.addAttribute("user", appUserDTO);
        return "customer/customerMainPage";
    }

    @GetMapping("/{id}/info")
    public String customerInfo(@PathVariable Long id, Model model) {
        //reservationService를 사용하여 주어진 고객 ID에 해당하는 예약 목록을 가져옴.
        List<Reservation> reservationList = reservationService.getReservationsByCustomerId(id);
        //reservationList를 스트림으로 변환한 다음, 현재 날짜 이전에 예약된 예약만 필터링하여 pastReservations 리스트에 저장
        List<Reservation> pastReservations = reservationList.stream()
                .filter(reservation -> reservation.getDateSlot().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        //reservationList를 스트림으로 변환한 다음, 현재 날짜 이후에 예약된 예약만 필터링하여 futureReservations 리스트에 저장
        List<Reservation> futureReservations = reservationList.stream()
                .filter(reservation -> !reservation.getDateSlot().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        model.addAttribute("pastResrvationsSize", pastReservations.size());
        model.addAttribute("pastReservations", pastReservations);
        model.addAttribute("futureReservations", futureReservations);
        model.addAttribute("id", id);

        return "customer/customerInfo";
    }

    //회원 info 에서 예약 삭제
    @DeleteMapping("/reservation/{reservationId}/delete")
    public ResponseEntity<?> reservationDelete(@PathVariable("reservationId") Long id) {
        try {
            reservationService.deleteReservation(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //customer 예약 수정
    @GetMapping("/{customerId}/reservation/{reservationId}/edit")
    public String reservationEditGet(@PathVariable("customerId") Long customerId, @PathVariable("reservationId") Long reservationId, Model model) {

        log.info("edit 페이지");
        Reservation reservation = reservationService.getReservationById(reservationId);

        List<Long> orderedMenuId = reservation.getOrderList().stream()
                .map(orderMenu -> orderMenu.getMenu().getMid())
                .collect(Collectors.toList());
        List<TableList> tableList = tableService.findAllTable();
        List<Menu> menuList = menuService.findAllMenu();

        model.addAttribute("customerId", customerId);
        model.addAttribute("reservationId", reservationId);
        model.addAttribute("tableList", tableList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("reservationForm", new ReservationForm(reservation.getMembers(), reservation.getDateSlot().toString(), reservation.getTimeSlot(), reservation.getTables().getTid(), orderedMenuId));
//        model.addAttribute("reservationForm", new ReservationForm());
//        model.addAttribute("reservation", reservation);
//        model.addAttribute("orderedMenuId", orderedMenuId);
        return "customer/reservationEdit";
    }

    // Ajax : customer edit 부분에서 date 와 time으로 테이블 예약 방지
    @GetMapping("/getAvailableTables")
    public ResponseEntity<?> getAvailableTables(@RequestParam("date") String date, @RequestParam("time") String time) {
        // date와 time을 이용해서 예약 가능한 테이블을 조회합니다.

        System.out.println("date = " + date);
        System.out.println("time = " + time);
        List<Long> selectTables = tableService.getAvailableTables(date, time);
        List<Long> allTables = tableService.findAllTable().stream().map(TableList -> TableList.getTid())
                .collect(Collectors.toList());
        System.out.println("tables.size() = " + selectTables.size());
        for (Long table : selectTables) {
            System.out.println("table_id= " + table);
        }
        Map<String, List<Long>> response = new HashMap<>();
        response.put("selectTables", selectTables);
        response.put("allTables", allTables);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{customerId}/reservation/{reservationId}/edit")
    public String reservationEdit(@PathVariable("customerId") Long customerId, @PathVariable("reservationId") Long reservationId, @ModelAttribute("reservationForm") ReservationForm reservationForm, Model model) {

        log.info("customerId : {}", customerId);
        log.info("reservationId : {}", reservationId);
        log.info("reservationForm : {}", reservationForm);
        reservationService.updateReservation(reservationId, reservationForm);
        return "redirect:/customer/{customerId}/info";
    }
//    @PutMapping()

    /*
     * Security login
     *
     */
    @RequestMapping("/login")
    public String loginString() {
        return "/customer/customerlogin";
    }

    @RequestMapping("/login?error=true")
    public String loginError(Model model) {
        model.addAttribute(null, model);
        return "/customer/customerlogin";
    }


    //    @GetMapping("customer/{id}")
//    public String viewCustomer(@PathVariable Long id, Model model) {
//
//        Customer customer = customerService.viewCustomer(id);
//        model.addAttribute("customer", customer);
//        return "customer/customerInfo";
//    }


    //회원 등록
//    @GetMapping("/register")
//    public String customerRegister(Model model) {
//        model.addAttribute("customer", new UserRegistForm(null, null, null, null, null));
//        return "/customer/registerForm";
//    }

//    @PostMapping("/register")
//    public String registerCustomer(@ModelAttribute("customer") CustomerRequestDTO request, BindingResult result) {
//        System.out.println("request : " + request);
//        customerService.addCustomer(request);
//        return "redirect:/";
//    }

    //회원 조회 -> id 있으면 admin에서 쓰는 것 아닐까?
//    @GetMapping("customer/{id}")
//    public String viewCustomer(@PathVariable Long id, Model model) {
//
//        Customer customer = customerService.viewCustomer(id);
//        model.addAttribute("customer", customer);
//        return "customer/customerInfo";
//    }

    // 회원 수정


    // 회원 삭제


}
