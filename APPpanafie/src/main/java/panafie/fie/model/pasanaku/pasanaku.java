package panafie.fie.model.pasanaku;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pasanaku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasanaku {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private int monto;
    private String descripcion;
    private String reglas;
    private LocalDate fechaInicio;
    private LocalDate duracion;
    private String moderador;

}



























