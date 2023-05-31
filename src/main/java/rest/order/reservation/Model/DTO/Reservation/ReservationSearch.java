package rest.order.reservation.Model.DTO.Reservation;

import rest.order.reservation.DefineEnum.TimeSlot;

import java.time.LocalDate;

public class ReservationSearch {
    private String name;
    private LocalDate date;
    private TimeSlot time;

    public ReservationSearch() {

    }

    public ReservationSearch(LocalDate date, TimeSlot time) {
        this.date = date;
        this.time = time;
    }

    public ReservationSearch(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
