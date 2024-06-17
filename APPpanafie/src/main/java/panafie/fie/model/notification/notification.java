package panafie.fie.model.notification;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
@Table(name = "notification")
public class Notification {
    
    @Id @GeneratedValue
    private Long id;
    
    private String tipo;
    
    private String mensaje;
    
    private LocalDate fecha;
    
    private String destinatario;
    
}
