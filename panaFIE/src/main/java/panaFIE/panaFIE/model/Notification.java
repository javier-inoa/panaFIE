package panaFIE.panaFIE.model;

import java.util.Date;
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
public class Notification {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User userId;

    @NotNull
    @ManyToOne
    private TypeNotification typeId;

    @NotNull
    private String description;

    @NotNull
    private Date date;

    @NotNull
    private String sender;
}
