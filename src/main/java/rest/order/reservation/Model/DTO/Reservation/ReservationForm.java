package rest.order.reservation.Model.DTO.Reservation;

import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.Menu.OrderMenuDTO;

import java.util.ArrayList;
import java.util.List;

public class ReservationForm {

    private int members;
    private String date; // 문자열 형태로
    private TimeSlot time; // 문자열 형탵로 -> enum으로 바꿀 수 있음

    private Long tid; // tableID

    // 예약한 메뉴의 리스트를 가져옴
    private List<Long> orderMenuList = new ArrayList<>();
    // change List<OrderMenuDTO> to List<Long> 
    //약간 이해는 안되는데 결국엔 여기 쓰이는 리스트는 그냥 for 를 위한 리스트라고 봐도 되나요? 

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

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    //    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }

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

    @Override
    public String toString() {
        return "ReservationForm{" +
                "members=" + members +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", tid=" + tid +
                ", orderMenuList=" + orderMenuList +
                '}';
    }


}
