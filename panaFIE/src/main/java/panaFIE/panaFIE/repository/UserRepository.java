package panaFIE.panaFIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panaFIE.panaFIE.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
