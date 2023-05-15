package rest.order.reservation.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.Reservation;

import java.time.LocalDate;
import java.util.List;

import static rest.order.reservation.Model.QReservation.reservation;


public class ReservationRepoImpl implements ReservationRepoCustom {
    private final JPAQueryFactory queryFactory;

    public ReservationRepoImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Reservation> findAll(ReservationSearch search) {

        return queryFactory.selectFrom(reservation)
                .where(
//                eqName(search.getName()),
                        eqDate(search.getDate()),
                        eqTime(search.getTime()))
                .fetch();
    }

    private BooleanExpression eqTime(TimeSlot time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        return reservation.timeSlot.eq(time);
    }

    private BooleanExpression eqDate(LocalDate date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return reservation.dateSlot.eq(date);
    }

//    private BooleanExpression eqName(String name) {
//        if (StringUtils.isEmpty(name)) {
//            return null;
//        }
//        return reservation.user.name.eq(name);
//    }


}
