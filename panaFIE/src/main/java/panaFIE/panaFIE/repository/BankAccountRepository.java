package panaFIE.panaFIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panaFIE.panaFIE.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount , Long>{

}
