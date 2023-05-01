package rest.order.reservation.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import rest.order.reservation.DefineEnum.TimeSlot;;

public interface TimeTable {

    

    LocalTime getArrivalTime();

    void setArrivalTime(TimeSlot timeSlot);


    LocalDate getDate();

    void setDate(LocalDate date);


    LocalTime getTime();

    void setTime(LocalTime time);


    //    Integer getCovers();
    //
    //    void setCovers(Integer );
    //    LocalTime getEndTime();

}
