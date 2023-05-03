package rest.order.reservation.Model;

import rest.order.reservation.DefineEnum.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;

;

public interface TimeTable {

    LocalTime getArrivalTime();

    void setArrivalTime(TimeSlot timeSlot);


    LocalDate getDate();

    void setDate(LocalDate date);


    TimeSlot getTime();

    void setTime(TimeSlot time);


    //    Integer getCovers();
    //
    //    void setCovers(Integer );
    //    LocalTime getEndTime();

}
