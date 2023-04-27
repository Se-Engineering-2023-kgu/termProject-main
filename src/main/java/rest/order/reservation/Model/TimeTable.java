package rest.order.reservation.Model;

import java.time.LocalDate;
import java.time.LocalTime;;

public interface TimeTable {

    

    LocalTime getArrivalTime();

    void setArrivalTime(LocalTime time);


    LocalDate getDate();

    void setDate(LocalDate date);


    LocalTime getTime();

    void setTime(LocalTime time);


    //    Integer getCovers();
    //
    //    void setCovers(Integer );
    //    LocalTime getEndTime();

}
