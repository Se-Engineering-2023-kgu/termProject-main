package rest.order.reservation.Model.DTO.Reservation;

import rest.order.reservation.Model.OrderMenu;

import java.util.ArrayList;
import java.util.List;

public class ReservationForm {

    private int members;
    private String date;
    private String time;
    private int tableNumber;
    private List<OrderMenu> orderList = new ArrayList<>();


    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
