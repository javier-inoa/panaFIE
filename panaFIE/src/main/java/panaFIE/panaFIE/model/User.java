package panaFIE.panaFIE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Role roleId;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private Integer state;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
