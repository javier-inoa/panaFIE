package panaFIE.panaFIE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @Min(1)
    private Integer accountNumber;

    @NotNull
    @Size(min = 2, max = 50)
    private String bank;

    @NotNull
    @Min(0)
    private Double balance;
}
