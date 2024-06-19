package panafie.fie.model.bankaccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    @NotNull
    private User userId;
    
    @NotNull
    private Integer accountNumber;
    
    @NotNull
    @Size(max = 100)
    private String bank;
    
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double balance;
}
