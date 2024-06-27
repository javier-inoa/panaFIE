/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import panafie.fie.dto.PasanakuDTO;
import panafie.fie.dto.PasanakuDTOConverter;
import panafie.fie.model.datepasanaku.DatePasanaku;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.model.rules.Rules;
import panafie.fie.repository.DatePasanakuRepository;
import panafie.fie.repository.PasanakuRepository;
import panafie.fie.repository.RuleRepository;
import panafie.fie.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apipanafie")
public class PasanakuController {

    private final PasanakuRepository pasanakuRepository;
    private final UserRepository userRepository;
    private final DatePasanakuRepository datePasanakuRepository;
    private final RuleRepository rulesRepository;
    private final PasanakuDTOConverter pasanakuDTOConverter;

    @GetMapping("/pasanakus")
    public ResponseEntity<?> getPasanakus() {
        List<Pasanaku> result = pasanakuRepository.findAll();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<PasanakuDTO> dtoList = result.stream().map(pasanakuDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/pasanakus/{id}")
    public ResponseEntity<?> getOnePasanaku(@PathVariable Long id) {
        Pasanaku result = pasanakuRepository.findById(id).orElse(null);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping("/pasanaku")
    public ResponseEntity<?> createPasanaku(@RequestBody PasanakuDTO pasanakuDTO) {
        DatePasanaku datePasanaku = new DatePasanaku();
        datePasanaku.setStartDate(pasanakuDTO.getStartDate());
        datePasanaku.setFinishDate(pasanakuDTO.getFinishDate());
        DatePasanaku savedDatePasanaku = datePasanakuRepository.save(datePasanaku);

        Rules rules = new Rules();
        rules.setAmountOfPeople(pasanakuDTO.getAmountOfPeople());
        rules.setAmount(pasanakuDTO.getAmount());
        rules.setDuration(pasanakuDTO.getDuration());
        rules.setTypeOfDraw(pasanakuDTO.getTypeOfDraw());
        Rules savedRules = rulesRepository.save(rules);

        Pasanaku pasanaku = new Pasanaku();
        pasanaku.setName(pasanakuDTO.getName());
        pasanaku.setDescription(pasanakuDTO.getDescription());
        pasanaku.setState(pasanakuDTO.getState());
        pasanaku.setUserId(null);
        pasanaku.setDateId(savedDatePasanaku);
        pasanaku.setRules(savedRules);
        Pasanaku savedPasanaku = pasanakuRepository.save(pasanaku);

        pasanakuDTO.setId(savedPasanaku.getId());
        pasanakuDTO.setDateId(savedDatePasanaku.getId());
        pasanakuDTO.setRulesId(savedRules.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(pasanakuDTO);
    }

    @PutMapping("/pasaku/{id}")
    public ResponseEntity<?> updatePasanaku(@RequestBody Pasanaku edit, @PathVariable Long id) {
        return pasanakuRepository.findById(id).map(p -> {
            p.setName(edit.getName());
            p.setDescription(edit.getDescription());
            return ResponseEntity.ok(pasanakuRepository.save(p));
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });
    }
    
    @PutMapping("/statepasaku/{id}")
    public ResponseEntity<?> updateStatePasanaku(@RequestBody Pasanaku edit, @PathVariable Long id) {
        return pasanakuRepository.findById(id).map(p -> {
            p.setState(edit.getState());
            return ResponseEntity.ok(pasanakuRepository.save(p));
        }).orElseGet(() -> {
            return ResponseEntity.notFound().build();
        });
    }
}
