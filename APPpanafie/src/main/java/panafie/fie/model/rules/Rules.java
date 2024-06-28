package panafie.fie.model.rules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; // Agrega esta importación
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn; // Agrega esta importación
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.pasanaku.Pasanaku;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rules {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @OneToOne
    @JoinColumn(name = "pasanaku_id")
    private Pasanaku pasanakuId;
    
    private Integer amountOfPeople;
    
    private Float amount;
    
    private String description;
    
    private String duration;
    
    private Boolean typeOfDraw;
    
}
