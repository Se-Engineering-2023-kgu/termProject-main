package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Repository.MenuRepo;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepo menuRepository;

    @Autowired
    public MenuService(MenuRepo menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu addMenu(MenuRegistForm menuDto) {  // entity로 변환해서 넣어야 할까요?

        Menu menuClass = new Menu(menuDto.getName(), menuDto.getIntro(), menuDto.getPrice(), menuDto.getType());


        return menuRepository.save(menuClass);
    }

    public Menu findMenu(Long id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> findAllMenu() {
        return menuRepository.findAll(); // jpaRepository 쓰면 되는건가요??
    }

    public void deleteMenu(Long id) {
        Menu menuClass = menuRepository.findById(id).get();
        menuRepository.delete(menuClass);
    }


}
