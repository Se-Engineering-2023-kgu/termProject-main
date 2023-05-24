package rest.order.reservation.Model.DTO.Reservation.form;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import rest.order.reservation.DefineEnum.TimeSlot;

public class ReservationDateForm {

    @NotNull
    @Range(min = 1, max = 10)
    private Integer members;
    @NotNull
    private String date;
    @NotNull
//    private TimeSlot time;
    private TimeSlot time;

    public ReservationDateForm(Integer members, String date, TimeSlot time) {
        this.members = members;
        this.date = date;
        this.time = time;
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

    @Override
    public String toString() {
        return "ReservationDateForm{" +
                "members=" + members +
                ", date='" + date + '\'' +
                ", time=" + time +
                '}';
    }
}
