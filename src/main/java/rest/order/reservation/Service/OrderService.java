package rest.order.reservation.Service;

import rest.order.reservation.Model.OrderMenu;
import rest.order.reservation.Repository.OrderRepo;

public class OrderService {
    OrderRepo orderRepo;
    OrderMenu orderMenu;
    MenuService menuService;

    //1 . 주문 메뉴 생성
    // 주문한 메뉴 : orderMenu 를 내부에서 생성하는 로직
    // OrderMenu : 예약할 때 Menu 1개 count 개수만큼 주문하는 메뉴 표현?


//    public OrderMenu createOrderMenu(Menu menu, int count) {
//        OrderMenu orderMenu = new OrderMenu();
//
//        orderMenu.setMenu(menu);
//        orderMenu.setCount(count);
//        int orderPrice = 5000; // menuService.MenuService(menu);
//        orderMenu.setOrderPrice(orderPrice);
//
//
//        // orderRepo.save(orderMenu); //  crudrepository 의 save 수행. insert 할 때 주의
//        // 이걸로 리턴한 orderMenu를 바탕으로 reservation_id와
//
//        return orderMenu;
//    }


}
