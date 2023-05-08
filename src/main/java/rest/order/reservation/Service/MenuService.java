package rest.order.reservation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.order.reservation.Model.DTO.Menu.MenuRegistForm;
import rest.order.reservation.Model.DTO.Menu.MenuRequestDTO;
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

    public void deleteMenu(Long id) {
        
        Optional<Menu> menuClass = menuRepository.findById(id);
        if (menuClass.isPresent()) {
            menuRepository.delete(menuClass.get());    
        } else {
            throw new RuntimeException("request Menu id is not found " + id);
        }   
    }
        
    // RAW menu usage 사용하면 안되고 DTO를 통해 개선 필요함 
    public Menu findMenu(Long id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> findAllMenu() {
        return menuRepository.findAll(); // jpaRepository 쓰면 되는건가요??
    }


    public MenuRequestDTO viewMenu(long id) {
        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isPresent()) {
            MenuRequestDTO menuDTO = MenuRequestDTO.from(menu.get());
            return menuDTO;
        } else {
            throw new RuntimeException("request Menu id is not found " + id);
        }
    }


	public MenuRequestDTO addMenu(MenuRequestDTO menuRequest) {

        Menu menu = new Menu(
                        null,
                        menuRequest.name(), 
                        menuRequest.intro(), 
                        menuRequest.price(), 
                        menuRequest.type()
                        );
        menuRepository.save(menu);
        // menu = new Menu(
        //     menu.getMid(),
        //     menuRequest.name(), 
        //     menuRequest.intro(), 
        //     menuRequest.price(), 
        //     menuRequest.type()
        // );

        // menuRepository.save(menu);
        return menuRequest;
        
	}

    public MenuRequestDTO editMenu(MenuRequestDTO menuRequest) {
        // Menu menu = menuRepository.findByid(); // Repo에 기능 넣어야 함, 그냥 리퀘 받을 때 id 도 받을걸 그랬나 
        
        Menu menu = null;
        if(menu != null){
        menu.setName(menuRequest.name());
        menu.setIntro(menuRequest.intro());
        menu.setPrice(menuRequest.price());
        menu.setType(menuRequest.type());
        menuRepository.save(menu);

        }
        else {
            throw new RuntimeException("Menu not found!");
        }
        return menuRequest;
        
	}

}


