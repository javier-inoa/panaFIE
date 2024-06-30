/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

import lombok.*;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter @Setter
public class PasanakuDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean state;

    private Boolean gameStarted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date finishDate;

    private Integer amountOfPeople;

    private Float amount;

    private String duration;

    private String typeOfDraw;
   
}
