package rest.order.reservation.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Repository.AppUserRepo;

@SpringBootTest
class UserServiceTest {


    @Autowired
    AppUserRepo appUserRepository;


    @Test
    @Transactional
    void loginCheck() {


    }
}
