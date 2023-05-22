package rest.order.reservation.Repository.User;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;
import rest.order.reservation.DefineEnum.UserClass;
import rest.order.reservation.Model.User.AppUser;
import rest.order.reservation.Model.User.AppUserSearch;

import java.util.List;

import static rest.order.reservation.Model.User.QAppUser.appUser;

public class AppUserRepoImpl implements AppUserRepoCustom {


    private final JPAQueryFactory queryFactory;

    public AppUserRepoImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public List<AppUser> findAll(AppUserSearch search) {
        return queryFactory.selectFrom(appUser)
                .where(
                        eqName(search.getName()),
                        appUser.userType.eq(UserClass.customer)) // userType을 'customer'로 고정
                .fetch();
    }

    private BooleanExpression eqName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return appUser.name.eq(name);
    }
}

