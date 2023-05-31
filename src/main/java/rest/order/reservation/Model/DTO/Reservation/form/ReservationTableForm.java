package rest.order.reservation.Model.DTO.Reservation.form;

import rest.order.reservation.DefineEnum.TimeSlot;

public class ReservationTableForm {
    private Integer members;
    private String date;
    private TimeSlot time;

    private Long tid;

    public ReservationTableForm(Integer members, String date, TimeSlot time, Long tid) {
        this.members = members;
        this.date = date;
        this.time = time;
        this.tid = tid;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
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

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "ReservationTableForm{" +
                "members=" + members +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", tid=" + tid +
                '}';
    }
}
