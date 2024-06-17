package panafie.fie.model.report;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id @GeneratedValue
    private Long id;
    
    private String typeUser;
    
    private Integer author;
    
    private LocalDate date;
    
    private String rules;
    
    private Integer transaction;
    
    private String type;
    
}
