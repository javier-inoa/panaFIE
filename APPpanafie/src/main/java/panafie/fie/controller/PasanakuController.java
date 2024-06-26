/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panafie.fie.dto.PasanakuDTO;
import panafie.fie.model.datepasanaku.DatePasanaku;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.model.rules.Rules;
import panafie.fie.model.user.User;
import panafie.fie.repository.DatePasanakuRepository;
import panafie.fie.repository.PasanakuRepository;
import panafie.fie.repository.RuleRepository;
import panafie.fie.repository.UserRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pasanakus")
public class PasanakuController {

    private final PasanakuRepository pasanakuRepository;
    private final UserRepository userRepository;
    private final DatePasanakuRepository datePasanakuRepository;
    private final RuleRepository rulesRepository;

    @PostMapping
    public ResponseEntity<PasanakuDTO> createPasanaku(@RequestBody PasanakuDTO pasanakuDTO) {
        // Buscar el usuario por ID
        //User user = userRepository.findById(pasanakuDTO.getUserId()).orElse(null);

        // Crear y guardar DatePasanaku
        DatePasanaku datePasanaku = new DatePasanaku();
        datePasanaku.setStartDate(pasanakuDTO.getStartDate());
        datePasanaku.setFinishDate(pasanakuDTO.getFinishDate());
        DatePasanaku savedDatePasanaku = datePasanakuRepository.save(datePasanaku);

        // Crear y guardar Rules
        Rules rules = new Rules();
        rules.setAmountOfPeople(pasanakuDTO.getAmountOfPeople());
        rules.setAmount(pasanakuDTO.getAmount());
        rules.setDuration(pasanakuDTO.getDuration());
        rules.setTypeOfDraw(pasanakuDTO.getTypeOfDraw());
        Rules savedRules = rulesRepository.save(rules);

        Pasanaku pasanaku = new Pasanaku();
        pasanaku.setName(pasanakuDTO.getName());
        pasanaku.setDescription(pasanakuDTO.getDescription());
        pasanaku.setUserId(null);
        pasanaku.setDateId(savedDatePasanaku);
        pasanaku.setRules(savedRules);
        Pasanaku savedPasanaku = pasanakuRepository.save(pasanaku);

        // Actualizar el DTO con los IDs generados
        pasanakuDTO.setId(savedPasanaku.getId());
        pasanakuDTO.setDateId(savedDatePasanaku.getId());
        pasanakuDTO.setRulesId(savedRules.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(pasanakuDTO);
    }
}