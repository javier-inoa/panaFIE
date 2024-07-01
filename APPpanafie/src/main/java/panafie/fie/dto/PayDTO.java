/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

/**
 *
 * @author nayeli.ticona
 */
import java.util.Date;
import lombok.Data;

@Data
public class PayDTO {
    private Long userId;
    private Float amount;
    private Date date;
}
