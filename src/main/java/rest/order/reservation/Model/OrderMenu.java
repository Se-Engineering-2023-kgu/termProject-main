package rest.order.reservation.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderMenu")
public class OrderMenu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int OrderID;

    public OrderMenu(int orderID) {
        OrderID = orderID;
    }

    public OrderMenu(){
        
    }

}
