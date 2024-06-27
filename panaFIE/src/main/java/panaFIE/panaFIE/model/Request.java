package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User userId;

    @NotNull
    @ManyToOne
    private Pasanaku pasanakuId;

    @NotNull
    @Size(min = 1, max = 1000)
    private String message;

    @NotNull
    @Min(0)
    @Max(2)
    private Integer status;

    @NotNull
    @FutureOrPresent 
    private Date date;

}
