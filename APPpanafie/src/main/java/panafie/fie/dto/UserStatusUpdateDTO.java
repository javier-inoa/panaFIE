package panafie.fie.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStatusUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    @Min(1)
    @Max(3)
    private Integer status;
}
