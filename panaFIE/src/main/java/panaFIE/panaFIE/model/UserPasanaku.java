package panaFIE.panaFIE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue
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
    private Boolean status;
}
