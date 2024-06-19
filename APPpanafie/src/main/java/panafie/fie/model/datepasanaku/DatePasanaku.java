package panafie.fie.model.datepasanaku;

import java.util.Date;
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
public class DatePasanaku {

    @Id @GeneratedValue
    private Long id;
    
    private Date startDate;
    
    private Date finishDate;
}
