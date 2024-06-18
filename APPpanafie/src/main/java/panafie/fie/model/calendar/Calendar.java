package panafie.fie.model.calendar;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User userId;
    //foren key user
    @NotNull
    private Date paymentDate;

    @NotNull
    private Date maximumPaymentDate;

    @NotNull
    private Float amount;

}
