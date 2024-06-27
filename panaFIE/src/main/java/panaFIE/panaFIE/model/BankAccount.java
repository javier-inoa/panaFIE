package panaFIE.panaFIE.model;

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
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    private Integer accountNumber;

    @NotNull
    private String bank;

    @NotNull
    private Double balance;
}
