package panafie.fie.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import panafie.fie.dto.CreatePasanakuDTO;
import panafie.fie.dto.PasanakuDTO;
import panafie.fie.dto.PasanakuDTOConverter;
import panafie.fie.model.datepasanaku.DatePasanaku;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.model.rules.Rule;
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

    //HU # GP-01 CREAR PASANAKUS
    @PostMapping("/pasanaku")
    public ResponseEntity<?> createPasanaku(@RequestBody CreatePasanakuDTO pasanakuDTO) {
        DatePasanaku datePasanaku = new DatePasanaku();
        datePasanaku.setStartDate(pasanakuDTO.getStartDate());
        datePasanaku.setFinishDate(pasanakuDTO.getFinishDate());
        DatePasanaku savedDatePasanaku = datePasanakuRepository.save(datePasanaku);

        Rule rule = new Rule();
        rule.setAmountOfPeople(pasanakuDTO.getAmountOfPeople());
        rule.setAmount(pasanakuDTO.getAmount());
        rule.setDuration(pasanakuDTO.getDuration());
        rule.setTypeOfDraw(pasanakuDTO.getTypeOfDraw());
        Rule savedRule = rulesRepository.save(rule);

        Pasanaku pasanaku = new Pasanaku();
        pasanaku.setName(pasanakuDTO.getName());
        pasanaku.setDescription(pasanakuDTO.getDescription());
        pasanaku.setState(pasanakuDTO.getState());
        pasanaku.setGameStarted(false);
        pasanaku.setUserId(null);
        pasanaku.setRuleId(savedRule);
        pasanaku.setDateId(savedDatePasanaku);
        return ResponseEntity.status(HttpStatus.CREATED).body(pasanakuRepository.save(pasanaku));
    }

    //HU # GP-02 LISTAR PASANAKUS
    @PostMapping("/pasanakus")
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

    //HU # GP-03 LISTAR BENEFICIARIOS
//    @PostMapping("/beneficiaries")
//    public ResponseEntity<?> getBeneficiaries(){
//        List<Beneficiaries> result = beneficiariesRepository.findAll();
//
//        if (result.isEmpty()){
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(result);
//        }
//    }

    //HU # GP-04 DAR DE BAJA PASANAKUS
    @PostMapping("/statepasanaku/{id}")
    public ResponseEntity<?> updateStatePasanaku(@RequestBody Map<String, Boolean> requestBody, @PathVariable Long id) {
        Boolean state = requestBody.get("state");
        if (state == null) {
            return ResponseEntity.badRequest().body("State parameter is required.");
        }

        return pasanakuRepository.findById(id).map(pasanaku -> {
            Date startDate = pasanaku.getDateId().getStartDate();

            LocalDate startLocalDate = startDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            LocalDate currentDate = LocalDate.now();

            if (currentDate.isBefore(startLocalDate)) {
                pasanaku.setState(state);
                return ResponseEntity.ok(pasanakuRepository.save(pasanaku));
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("No se puede actualizar el estado. El pasanaku ya ha iniciado.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    //HU # GP-05 EDITAR PASANAKUS
    @PostMapping("/updatepasanaku/{id}")
    public ResponseEntity<?> updatePasanaku(@RequestBody CreatePasanakuDTO pasanakuDTO, @PathVariable Long id) {
        return pasanakuRepository.findById(id).map(existingPasanaku -> {
            Date startDate = existingPasanaku.getDateId().getStartDate();
            LocalDate startLocalDate = startDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentDate = LocalDate.now();

            if (currentDate.isBefore(startLocalDate)) {
                existingPasanaku.setName(pasanakuDTO.getName());
                existingPasanaku.setDescription(pasanakuDTO.getDescription());

                Rule rule = existingPasanaku.getRuleId();
                rule.setAmountOfPeople(pasanakuDTO.getAmountOfPeople());
                rule.setAmount(pasanakuDTO.getAmount());
                rule.setDuration(pasanakuDTO.getDuration());
                rule.setTypeOfDraw(pasanakuDTO.getTypeOfDraw());

                existingPasanaku.setRuleId(rulesRepository.save(rule));
                return ResponseEntity.ok(pasanakuRepository.save(existingPasanaku));
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("No se puede actualizar el Pasanaku. Ya inicio.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }


    //HU # GP-07 INICIAR O CERRAR PASANAKU
    @PostMapping("/startgame/{id}")
    public ResponseEntity<String> startGame(@PathVariable Long id) {
        return pasanakuRepository.findById(id).map(pasanaku -> {
            pasanaku.setGameStarted(true);
            pasanakuRepository.save(pasanaku);
            return ResponseEntity.ok("Pasanaku Started Correctly");
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/closegame/{id}")
    public ResponseEntity<String> closeGame(@PathVariable Long id) {
        return pasanakuRepository.findById(id).map(pasanaku -> {
            pasanaku.setGameStarted(false);
            pasanakuRepository.save(pasanaku);
            return ResponseEntity.ok("Pasanaku Closed Correctly");
        }).orElse(ResponseEntity.notFound().build());
    }

    //HU # GP-11 VISUALIZAR PASANAKU
    @PostMapping("/pasanakus/{id}")
    public ResponseEntity<?> getOnePasanaku(@PathVariable Long id) {
        Pasanaku result = pasanakuRepository.findById(id).orElse(null);

        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}
