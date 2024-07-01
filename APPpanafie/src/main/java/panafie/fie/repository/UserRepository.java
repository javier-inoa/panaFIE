package panafie.fie.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import panafie.fie.model.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User>findByEmailAndPassword(String email, String password);
    
    Optional<User>findByEmail(String email);
    
    List<User> findByStatusNot(int status);
}
