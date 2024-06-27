package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rule {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @ManyToOne
    private Pasanaku pasanakuId;
    
    @NotNull
    @Positive
    @Min(2)
    private Integer amountOfPeople;
    
    @NotNull
    @Positive
    private Double amount;
    
    @NotNull
    @Size(min = 1, max = 1000)
    private String description;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String duration;
    
    @NotNull
    private Boolean typeOfDraw;
}
