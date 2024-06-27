/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

import lombok.*;

import java.util.Date;

@Getter @Setter
public class PasanakuDTO {
    
    private Long id;
    
    private String name;
    
    private String description;
    
    private Boolean state;
    
    private Long userId;
    
    private Long dateId;
    
    private Long rulesId;
    
    private Date startDate;
    
    private Date finishDate;
    
    private Integer amountOfPeople;
    
    private Float amount;
    
    private String duration;
    
    private String typeOfDraw;
   
}
