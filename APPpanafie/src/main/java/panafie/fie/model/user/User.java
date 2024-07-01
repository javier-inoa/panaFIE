package panafie.fie.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.role.Role;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @ManyToOne
    private Role roleId;
    
    @NotNull
    @Size(max = 50)
    private String name;
    
    @NotNull
    @Size(max = 50)
    private String lastName;
    
    @NotNull
    @Min(value = 1)
    @Max(value = 3)
    private Integer status;
    
    @NotNull
    @Email
    @Size(max = 100)
    private String email;
    
    @NotNull
    @Size(max = 255)
    private String password;
    
}
