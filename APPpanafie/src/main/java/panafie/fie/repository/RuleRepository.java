/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package panafie.fie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panafie.fie.model.rules.Rules;

/**
 *
 * @author alejandro.reyes
 */
public interface RuleRepository extends JpaRepository<Rules, Long>{
    
}
