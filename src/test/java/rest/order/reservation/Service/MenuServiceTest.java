package rest.order.reservation.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.Menu;

@SpringBootTest
@Transactional
class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    public void find() {
        //given
        MenuRegistForm param = new MenuRegistForm();
        param.setName("HELLO");
        //when
        Menu menu1 = menuService.addMenu(param);
        System.out.println("menu1 : " + menu1.getName());
        //then

    }

}