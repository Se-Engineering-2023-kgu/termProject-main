package rest.order.reservation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.order.reservation.Model.Menu;
import rest.order.reservation.Model.DTO.MenuDTO;
import rest.order.reservation.Model.DTO.MenuDTOMapper;
import rest.order.reservation.Model.DTO.MenuRequestDTO;
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


    public Menu findMenu(Long id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> findAllMenu() {
        return (List<Menu>) menuRepository.findAll(); // jpaRepository 쓰면 되는건가요??
    }

    public void deleteMenu(Long id) {
        Menu menuClass = menuRepository.findById(id).get();
        menuRepository.delete(menuClass);
    }


    public MenuDTO viewMenu(long id) {
        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isPresent()) {
            MenuDTO menuDTO = menuDTOMapper.apply(menu.get());
            return menuDTO;
        } else {
            throw new RuntimeException("request Menu id is not found " + id);
        }
        

    }


	public MenuRequestDTO addMenu(MenuRequestDTO menuRequest) {
        Menu menu = new Menu(
                        menuRequest.name(), 
                        menuRequest.intro(), 
                        menuRequest.price(), 
                        menuRequest.type()
                        );
        return menuRequest;
        
	}




    
}
