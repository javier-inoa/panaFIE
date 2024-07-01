package panafie.fie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panafie.fie.model.role.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
