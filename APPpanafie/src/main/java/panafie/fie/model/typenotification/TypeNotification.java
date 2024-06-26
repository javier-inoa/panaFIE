package panafie.fie.model.typenotification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    
    @NotBlank
    @Size(max = 50)
    private String name;
    
    @Size(max = 255)
    private String description;
