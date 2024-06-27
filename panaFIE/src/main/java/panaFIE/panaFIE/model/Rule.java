package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
    private Integer amountOfPeople;
    
    @NotNull
    private Double amount;
    
    @NotNull
    private String description;
    
    @NotNull
    private String duration;
    
    @NotNull
    private Boolean typeOfDraw;
}
