package rest.order.reservation.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.DTO.Reservation.ReservationForm;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.Reservation;
import rest.order.reservation.Model.TableList;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Repository.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AppUserRepo appUserRepository;
    @Autowired
    TableRepo tableRepository;
    @Autowired
    MenuRepo menuRepository;
    @Autowired
    ReservationRepo reservationRepository;
    @Autowired
    OrderMenuRepo orderMenuRepository;

    @Test
    void addReservation() {
    }

    @Test
    void findAllReservation() {
    }

    @Test
    @Transactional
    void deleteReservation() {
        AppUser user = createUser();
        System.out.println("user = " + user.getUid());
        TableList table = createTable(1);
        System.out.println("table = " + table.getTid());
        Menu menu1 = createMenu1("menu1");
        System.out.println("menu1  = " + menu1.getMid());
        Menu menu2 = createMenu2("menu2");
        System.out.println("menu2  = " + menu2.getMid());

        List<Long> orderMenuList = new ArrayList<>();
        orderMenuList.add(menu1.getMid());
        orderMenuList.add(menu2.getMid());
        System.out.println("orderMenuList.size() = " + orderMenuList.size());

        ReservationForm rvf = new ReservationForm(3, "2023-05-13", TimeSlot.EIGHT, table.getTid(), orderMenuList);

        Long id = reservationService.addReservation(user.getUid(), rvf);
        Reservation reservation = reservationRepository.findById(id).get();
        Assertions.assertEquals(rvf.getMembers(), reservation.getMembers());  // 일치한다는 것은 알 수 있다.
        Assertions.assertEquals(orderMenuRepository.count(), 8); // 현재 db에 6 개 있었기 때문에 2개가 추가되면 8
        Assertions.assertEquals(reservationRepository.count(), 3); // db에 2개였기 때문에 1개 추가 되어 3

        reservationService.deleteReservation(id);
        System.out.println("reservationRepository.count() = " + reservationRepository.count());
        Assertions.assertEquals(reservationRepository.count(), 2); // 삭제후  2
        Assertions.assertEquals(orderMenuRepository.count(), 6);  // 삭제후 6

        // 삭제 test
// ---------------------------------------------------------------------------------------------------------------------------------


    }

    @Test
    @Transactional
    void updateReservation() {

        AppUser user = createUser();
        System.out.println("user = " + user.getUid());
        TableList table = createTable(1);
        System.out.println("table = " + table.getTid());
        Menu menu1 = createMenu1("menu1");
        System.out.println("menu1  = " + menu1.getMid());
        Menu menu2 = createMenu2("menu2");
        System.out.println("menu2  = " + menu2.getMid());

        List<Long> orderMenuList = new ArrayList<>();
        orderMenuList.add(menu1.getMid());
        orderMenuList.add(menu2.getMid());
        System.out.println("orderMenuList.size() = " + orderMenuList.size());


        ReservationForm rvf = new ReservationForm(3, "2023-05-13", TimeSlot.EIGHT, table.getTid(), orderMenuList);

        System.out.println("1. reservationRepository.count() = " + reservationRepository.count());
        Long id = reservationService.addReservation(user.getUid(), rvf);
        System.out.println("2. reservationRepository.count() = " + reservationRepository.count());
        Reservation reservation = reservationRepository.findById(id).get();
        Assertions.assertEquals(rvf.getMembers(), reservation.getMembers());  // 일치한다는 것은 알 수 있다.
        Assertions.assertEquals(orderMenuRepository.count(), 8); // 현재 db에 6 개 있었기 때문에 2개가 추가되면 8
        Assertions.assertEquals(reservationRepository.count(), 3); // db에 2개였기 때문에 1개 추가 되어 3

        System.out.println("before ReservationId : " + reservation.getReservationID());
        System.out.println("before ReservationMembers : " + reservation.getMembers());
        System.out.println("before ReservationTables : " + reservation.getTables().getNumber());
        System.out.println("before ReservationDateSlot : " + reservation.getDateSlot());
        System.out.println("before ReservationTimeSlot : " + reservation.getTimeSlot());
        System.out.println("before Reservation : " + reservation.getOrderList().get(0).getMenu().getName());
        System.out.println("before Reservation : " + reservation.getOrderList().get(1).getMenu().getName());
//      ---------------------------------------------------------------------------------------------------------------

        TableList table2 = createTable(4);  // tableNumber 변경
        System.out.println("table = " + table2.getTid());
        Menu menu3 = createMenu1("menu3");  // menu1 이름 변경
        System.out.println("menu3  = " + menu3.getMid());
        Menu menu4 = createMenu2("menu4");  // menu2 이름 변경
        System.out.println("menu4  = " + menu4.getMid());


        List<Long> orderMenuList2 = new ArrayList<>();
        orderMenuList2.add(menu3.getMid());
        orderMenuList2.add(menu4.getMid());
        System.out.println("orderMenuList.size() = " + orderMenuList.size());

        ReservationForm rvf2 = new ReservationForm(4, "2023-05-14", TimeSlot.ELEVEN, table2.getTid(), orderMenuList2);
        reservationService.updateReservation(id, rvf2);
        System.out.println("3. reservationRepository.count() = " + reservationRepository.count());

        System.out.println("after ReservationId : " + reservation.getReservationID());
        System.out.println("after ReservationMembers : " + reservation.getMembers());
        System.out.println("after ReservationTables : " + reservation.getTables().getNumber());
        System.out.println("after ReservationDateSlot : " + reservation.getDateSlot());
        System.out.println("after ReservationTimeSlot : " + reservation.getTimeSlot());
        System.out.println("after Reservation : " + reservation.getOrderList().get(0).getMenu().getName());
        System.out.println("after Reservation : " + reservation.getOrderList().get(1).getMenu().getName());

        System.out.println("4. reservationRepository.count() = " + reservationRepository.count());

        
        reservationService.deleteReservation(id);
//        System.out.println("5. reservationRepository.count() = " + reservationRepository.count());
//        Assertions.assertEquals(reservationRepository.count(), 2); // 삭제후  2
//        Assertions.assertEquals(orderMenuRepository.count(), 6);  // 삭제후 6
    }

    private AppUser createUser() {
        AppUser user = new AppUser();

        user.setName("jookbooin");
        user.setEmail("lsh");
        user.setUserType(UserClass.customer);
        user.setPhoneNumber("11");
        user.setEmail("11");
        appUserRepository.save(user);
        return user;
    }

    private Menu createMenu1(String name) {
        Menu menu = new Menu();
        menu.setName(name);
        menu.setPrice(10L);
        menuRepository.save(menu);
        return menu;
    }

    private Menu createMenu2(String name) {
        Menu menu = new Menu();
        menu.setName(name);
        menu.setPrice(12L);
        menuRepository.save(menu);
        return menu;
    }

    private TableList createTable(int num) {
        TableList table = new TableList();
        table.setNumber(num);
        tableRepository.save(table);
        return table;
    }

}