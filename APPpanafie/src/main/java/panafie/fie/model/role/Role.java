package panafie.fie.model.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id @GeneratedValue
    private Long id;
    
    @NotNull
    @Column(unique = true)
    @Size(max = 50)
    private String name;
    
    @Size(max = 250)
    private String description;
}
