package panaFIE.panaFIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panaFIE.panaFIE.model.Question;

public interface QuestionRepository extends JpaRepository<Question , Long>{

}
