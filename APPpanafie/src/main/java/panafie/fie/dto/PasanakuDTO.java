/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import panafie.fie.model.datepasanaku.DatePasanaku;
import panafie.fie.model.rules.Rules;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasanakuDTO {
    private String name;
    
    private String description;
    
    private Rules amountOfPeople;
    
    private Rules amount;
    
    private Rules duration;
    
    private Rules typeOfDraw;
    
    private DatePasanaku startDate;
    
    private DatePasanaku finishDate;
    
}
