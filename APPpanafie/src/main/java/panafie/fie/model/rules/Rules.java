package panafie.fie.model.rules;

import javax.persistence.*;

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
    private Long id;

    private Integer amountOfPeople;

    private Float amount;

    private String description;

    private String duration;

    private String typeOfDraw;
    
}
