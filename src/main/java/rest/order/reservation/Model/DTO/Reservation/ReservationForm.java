package rest.order.reservation.Model.DTO.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationForm {


    private int members;

    private String date; // 문자열 형태로

    private String time; // 문자열 형탵로 -> enum으로 바꿀 수 있음

    private Long tid; // tableID

    private List<Long> orderMenuList = new ArrayList<>();


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


    public List<Long> getOrderMenuList() {
        return orderMenuList;
    }

    public void setOrderMenuList(List<Long> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}
