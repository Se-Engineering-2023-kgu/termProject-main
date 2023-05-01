package rest.order.reservation.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import rest.order.reservation.DefineEnum.TimeSlot;;

public interface TimeTable {

    

    LocalTime getArrivalTime();

    void setArrivalTime(LocalTime time);


    LocalDate getDate();

    void setDate(LocalDate date);


    TimeSlot getTime();

    void setTime(TimeSlot time);


    //    Integer getCovers();
    //
    //    void setCovers(Integer );
    //    LocalTime getEndTime();

}
