package panaFIE.panaFIE.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import panaFIE.panaFIE.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User>findByEmailAndPassword(String email, String password);
}
