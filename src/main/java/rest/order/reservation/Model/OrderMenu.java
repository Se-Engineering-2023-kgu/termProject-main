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


    // orderMenu 생성 메소드
    public static OrderMenu createOrderMenu(Menu menu, int count) {
        OrderMenu orderMenu = new OrderMenu();
        orderMenu.setMenu(menu);
        orderMenu.setCount(count);
        return orderMenu;
    }

    // 조회 로직
    // 1. 가격 조회
    // Reservation 이 가지고 있는 주문상품에 대한 총 가격을 표현하기 위해서
    // for(OrderMenu orderMenu : orderList)
    //        totalPrice += orderMenu.getTotalPrice()  로 계산하면 될듯

    public int getTotalPrice() {
        return getCount() * getOrderPrice();
    }


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
