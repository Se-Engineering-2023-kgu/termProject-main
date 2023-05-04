package rest.order.reservation.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderMenu")
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_menu_id")
    private Long orderMenuID;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;  // 메뉴 1 - 주문 메뉴 n

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservationID; // 예약 1 - 주문 메뉴 종류 n
    @Column(name = "order_price")
    private int orderPrice; // 한종류 주문시점 가격
    @Column(name = "count")
    private int count; // 한종류 주문시점 수량

    //생성로직 은 service 이동시킴
    public OrderMenu createOrderMenu(Menu menu, int price, int count) {
        OrderMenu orderMenu = new OrderMenu();
        orderMenu.setMenu(menu);
        orderMenu.setOrderPrice(price);
        orderMenu.setCount(count);
        // orderRepo.save(orderMenu); //  crudrepository 의 save 수행. insert 할 때 주의
        // 이걸로 리턴한 orderMenu를 바탕으로 reservation_id와
        return orderMenu;
    }

    // 조회 로직
    public int getTotalPrice() {
        return getCount() * getOrderPrice();
    }
    // 1. 가격 조회
    // Reservation 이 가지고 있는 주문상품에 대한 총 가격을 표현하기 위해서
    // for(OrderMenu orderMenu : orderList)
    //        totalPrice += orderMenu.getTotalPrice()  로 계산하면 될듯


    public Long getOrderMenuID() {
        return orderMenuID;
    }

    public void setOrderMenuID(Long orderMenuID) {
        this.orderMenuID = orderMenuID;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Reservation getReservationID() {
        return reservationID;
    }

    public void setReservationID(Reservation reservationID) {
        this.reservationID = reservationID;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
