package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Model.Menu;
import rest.order.reservation.Repository.MenuRepo;

@Service
public class MenuService {

    private final MenuRepo menuRepository;

    @Autowired
    public MenuService(MenuRepo menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(MenuDTO menuDto) {  // entity로 변환해서 넣어야 할까요?

        Menu menuClass = new Menu();
        menuClass.setName(menuDto.getName());
        menuClass.setIntro(menuDto.getIntro());
        menuClass.setPrice(menuDto.getPrice());
        menuClass.setType(menuDto.getType());

        menuRepository.save(menuClass);
    }

    public Menu findMenu(Long id) {
        return menuRepository.findById(id).get();
    }

    //    public List<Menu> findAllMenu() {
//        return menuRepository.findAll(); // jpaRepository 쓰면 되는건가요??
//        return menuRepository.findAll();
//    }
    public void deleteMenu(Long id) {
        Menu menuClass = menuRepository.findById(id).get();
        menuRepository.delete(menuClass);
    }

}
