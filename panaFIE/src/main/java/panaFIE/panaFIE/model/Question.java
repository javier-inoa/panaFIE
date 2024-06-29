package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pasanaku_id")
    private Pasanaku pasanakuId;

    @NotNull
    @Size(min = 1, max = 1000)
    private String message;

    @NotNull
    @Size(min = 1, max = 1000)
    private String answer;

    @NotNull
    @FutureOrPresent
    private Date date;

}
