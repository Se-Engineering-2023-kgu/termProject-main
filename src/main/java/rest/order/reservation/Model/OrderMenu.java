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
    // 아마 여기가 맞을 것 같은데 service를 통해 레포를 가지고 넣어서 쓰는 거니까...


    // 조회 로직

    // 1. 가격 조회
    // Reservation 이 가지고 있는 주문상품에 대한 총 가격을 표현하기 위해서
    // for(OrderMenu orderMenu : orderList)
    //        totalPrice += orderMenu.getTotalPrice()  로 계산하면 될듯


    public Long getOrderMenuID() {
        return orderMenuID;
    }

    public Menu getMenu() {
        return menu;
    }

    public Reservation getReservationID() {
        return reservationID;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }
}
