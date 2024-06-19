package panafie.fie.model.notification;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.typenotification.TypeNotification;
import panafie.fie.model.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User userId;
    
    @ManyToOne
    private TypeNotification typeId;
    
    private String description;
    
    private Date date;
    
    private String sender;
}
