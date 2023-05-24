package rest.order.reservation.Model.DTO.Reservation;

import rest.order.reservation.DefineEnum.TimeSlot;

import java.time.LocalDate;
import java.util.List;

public class ReservationEditForm {

    private Integer members; // view 에서 가져오는 예약 인원

    private LocalDate date; // view 에서 가져오는 date
//    private TimeSlot time; // view에서 가져오는 time 문자열 형태

    private TimeSlot time;
    private Long tid; // view  가져오는 고객이 선택한 tableID

    // checkBox를 썼을 시 :  고객이 예약시 선택한 메뉴들을 form 안에 list 형태로 가져오려고 한 것입니다.
    private List<Long> orderMenuList; // view 에서 가져오는 메뉴들의 id
    // 여기서 id로 가져온 이유는 체크박스였기 때문에... service에서 for문으로 id를 통해 메뉴를 찾으려고 했습니다.

    public ReservationEditForm() {
    }

    public ReservationEditForm(Integer members, LocalDate date, TimeSlot time, Long tid, List<Long> orderMenuList) {
        this.members = members;
        this.date = date;
        this.time = time;
        this.tid = tid;
        this.orderMenuList = orderMenuList;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public List<Long> getOrderMenuList() {
        return orderMenuList;
    }

    public void setOrderMenuList(List<Long> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }
}
