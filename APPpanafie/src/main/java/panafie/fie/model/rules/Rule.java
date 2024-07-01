package panafie.fie.model.rules;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount_of_people")
    private Integer amountOfPeople;

    private Float amount;

    private String duration;

    @Column(name = "type_of_draw")
    private String typeOfDraw;
    
}
