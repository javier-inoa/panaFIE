package panafie.fie.model.typenotification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeNotification {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String description;
}
