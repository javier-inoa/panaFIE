package panafie.fie.model.pasanaku;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.datepasanaku.DatePasanaku;
import panafie.fie.model.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasanaku {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User userId;
    
    @ManyToOne
    private DatePasanaku dateId;
    
    private String name;
    
    private String description;
}

