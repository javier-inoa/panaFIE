/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.dto;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.dto.PasanakuDTO;

@Component
@RequiredArgsConstructor
public class PasanakuDTOConverter {
    
    private final ModelMapper modelMapper;

    public PasanakuDTO convertToDto(Pasanaku pasanaku) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true); // Ignora ambigüedades en mapeos

        PasanakuDTO pasanakuDTO = modelMapper.map(pasanaku, PasanakuDTO.class);

        // Mapear manualmente los campos de Rule y DatePasanaku si es necesario
        if (pasanaku.getRuleId() != null) {
            pasanakuDTO.setAmountOfPeople(pasanaku.getRuleId().getAmountOfPeople());
            pasanakuDTO.setAmount(pasanaku.getRuleId().getAmount());
            pasanakuDTO.setDuration(pasanaku.getRuleId().getDuration());
            pasanakuDTO.setTypeOfDraw(pasanaku.getRuleId().getTypeOfDraw());
        }

        if (pasanaku.getDateId() != null) {
            pasanakuDTO.setStartDate(pasanaku.getDateId().getStartDate());
            pasanakuDTO.setFinishDate(pasanaku.getDateId().getFinishDate());
        }

        return pasanakuDTO;
    }
}
