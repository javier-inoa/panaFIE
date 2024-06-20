/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package panafie.fie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panafie.fie.model.user.User;

/**
 *
 * @author alejandro.reyes
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
