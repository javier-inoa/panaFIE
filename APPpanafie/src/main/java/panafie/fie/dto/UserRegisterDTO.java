package panafie.fie.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
   
    @NotNull
    @Size(max = 50)
    private String name;
    
    @NotNull
    @Size(max = 50)
    private String lastName;
    
    @NotNull
    @Email
    @Size(max = 100)
    private String email;
    
    @NotNull
    @Size(max = 255)
    private String password;
}
