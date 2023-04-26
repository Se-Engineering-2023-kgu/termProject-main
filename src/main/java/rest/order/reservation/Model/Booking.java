package rest.order.reservation.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Booking {
    LocalTime getArrivalTime();

    void setArrivalTime(LocalTime time);


    LocalDate getDate();

    void setDate(LocalDate date);


    LocalTime getTime();

    void setTime(LocalTime time);

    List<Tables> getTables();

    void setTables(List<Tables> tablesList);
    //    Integer getCovers();
    //
    //    void setCovers(Integer );
    //    LocalTime getEndTime();

}
