package panafie.fie.model.rules;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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
    
    @NotNull
    private Pasanaku pasanakuId;
    
    @NotNull
    @Positive
    private Integer amountOfPeople;
    
    @NotNull
    @Positive
    private Float amount;
    
    @Size(max = 255)
    private String description;
    
    @Size(max = 50)
    private String duration;
    
    @NotNull
    private Boolean typeOfDraw;
    
}

