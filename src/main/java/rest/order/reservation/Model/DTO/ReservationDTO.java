package rest.order.reservation.Model.DTO;

import rest.order.reservation.Model.OrderMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDTO {

    private int members;
    private LocalDate date;
    private LocalTime time;

    //    private TimeSlot timeSlot;
    private List<OrderMenu> orderList = new ArrayList<>();
    private int tableNumber;

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public List<OrderMenu> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMenu> orderList) {
        this.orderList = orderList;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
