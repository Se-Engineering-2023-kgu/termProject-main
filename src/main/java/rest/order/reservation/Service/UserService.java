package rest.order.reservation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.order.reservation.Repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }


}
