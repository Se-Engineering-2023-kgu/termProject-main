package rest.order.reservation.Repository.Reservation;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;
import rest.order.reservation.DefineEnum.TimeSlot;
import rest.order.reservation.Model.DTO.Reservation.ReservationSearch;
import rest.order.reservation.Model.Reservation;

import java.time.LocalDate;
import java.util.List;

import static rest.order.reservation.Model.QReservation.reservation;
import static rest.order.reservation.Model.User.QAppUser.appUser;


public class ReservationRepoImpl implements ReservationRepoCustom {
    // querydsl을 사용하기위해서 config에 bean 강제 주입
    private final JPAQueryFactory queryFactory;

    public ReservationRepoImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Reservation> findAll(ReservationSearch search) {

        return queryFactory.selectFrom(reservation)
                .join(reservation.user, appUser)
                .where(
                        eqName(search.getName()),
                        eqDate(search.getDate()),
                        eqTime(search.getTime()))
                .fetch();
    }

    // 동적 쿼리 time 조건
    private BooleanExpression eqTime(TimeSlot time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        return reservation.timeSlot.eq(time);
    }

    // 동적 쿼리 date 조건
    private BooleanExpression eqDate(LocalDate date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return reservation.dateSlot.eq(date);
    }

    // 동적 쿼리 이름 조건
    private BooleanExpression eqName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return reservation.user.name.eq(name);
    }


}
