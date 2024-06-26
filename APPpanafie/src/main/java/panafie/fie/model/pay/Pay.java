package panafie.fie.model.pay;


import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import panafie.fie.model.user.User;

@Entity
public class Pay {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    @NotNull
    private User userId;
    
    @NotNull
    @Positive
    private BigDecimal amount;
    
    @NotNull
    private LocalDate paymentDate;
    
    @Size(max = 255)
    private String description;
    
    public Pay() {
        // Constructor vacío requerido por JPA
        
        
    }

    // Getters y setters
    // Métodos adicionales según sea necesario
}
