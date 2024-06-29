package panaFIE.panaFIE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Positive
    @Min(2)
    private Integer amountOfPeople;
    
    @NotNull
    @Positive
    private Double amount;
    
    @NotNull
    @Positive
    private Double totalAmount;
    
    @NotNull
    @Size(min = 1, max = 1000)
    private String description;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String duration;
    
    @NotNull
    private Boolean typeOfDraw;
}
