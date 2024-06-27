package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pay {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User userId;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    @FutureOrPresent
    private Date date;
}
