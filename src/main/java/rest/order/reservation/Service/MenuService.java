package rest.order.reservation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Model.DTO.MenuDTOMapper;
import rest.order.reservation.Repository.MenuRepo;

@Service
public class MenuService {


    private final MenuDTOMapper menuDTOMapper;
    private final MenuRepo menuRepository;

    @Autowired
    public MenuService(MenuDTOMapper menuDTOMapper, MenuRepo menuRepo) {
        this.menuDTOMapper = menuDTOMapper;
        this.menuRepository = menuRepo;
    }

    public MenuDTO saveMenu(MenuDTO menuDTO) {
        Menu menu = new Menu(
                menuDTO.name(),
                menuDTO.intro(),
                menuDTO.price(),
                menuDTO.type()
        );
        menuRepository.save(menu);
        return menuDTOMapper.apply(menu);
    }

    
}
