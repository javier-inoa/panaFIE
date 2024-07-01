package panafie.fie.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import panafie.fie.model.role.Role;

@Setter
@Getter
public class UserRoleUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    private Role roleId;
}
