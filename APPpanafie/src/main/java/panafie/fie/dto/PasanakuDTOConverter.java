/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import panafie.fie.model.pasanaku.Pasanaku;

@Component
@RequiredArgsConstructor
public class PasanakuDTOConverter {
    
    private final ModelMapper modelMapper;
    
    public PasanakuDTO convertToDto(Pasanaku pasanaku){
        return modelMapper.map(pasanaku, PasanakuDTO.class);
    }
}
