package panaFIE.panaFIE.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPasanaku {

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
    @Positive
    private Integer turn;
    
    @NotNull
    @Future
    private Date date;
    
    @NotNull
    private Boolean status;
}
