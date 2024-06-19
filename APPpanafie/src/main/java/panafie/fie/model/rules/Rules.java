package panafie.fie.model.rules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.pasanaku.Pasanaku;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rules {

    @Id @GeneratedValue
    private Long id;
    
    private Pasanaku pasanakuId;
    
    private Integer amountOfPeople;
    
    private Float amount;
    
    private String description;
    
    private String duration;
    
    private Boolean typeOfDraw;
    
}
