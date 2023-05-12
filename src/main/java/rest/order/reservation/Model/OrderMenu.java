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

    public OrderMenu() {
    }

    public OrderMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public OrderMenu(Menu menu, int orderPrice, int count) {
        this.menu = menu;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    // orderMenu 생성 메소드
    // 이게 정적 팩토리 메소드 인가?
    public static OrderMenu createOrderMenu(Menu menu, int count) {
        return new OrderMenu(menu, (int) (menu.getPrice() * count), count);
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
