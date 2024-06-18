package panafie.fie.model.pay;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pay {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User userId;
    
    private Float amount;
    
    private Date date;
}
