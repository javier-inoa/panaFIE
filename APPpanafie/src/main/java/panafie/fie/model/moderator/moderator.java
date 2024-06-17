package panafie.fie.model.moderator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "moderator")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moderator {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String rol = "moderador";
    private int cantidadJuegos;

}
