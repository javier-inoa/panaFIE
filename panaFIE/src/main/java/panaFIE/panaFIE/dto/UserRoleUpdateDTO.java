package panaFIE.panaFIE.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import panaFIE.panaFIE.model.Role;

@Setter
@Getter
public class UserRoleUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    private Role roleId;
}
