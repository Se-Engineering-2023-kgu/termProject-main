package rest.order.reservation.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Long id = menuService.addMenu(param);
        Menu menu = menuService.findMenu(id);
        assertEquals(id, menu.getMid());
    }

}