/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import panafie.fie.dto.RequestDTO;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.model.request.Request;
import panafie.fie.model.user.User;

import panafie.fie.repository.PasanakuRepository;
import panafie.fie.repository.RequestRepository;
import panafie.fie.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apipanafie")
public class RequestController {
    private final PasanakuRepository pasanakuRepository;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;

    @Operation(summary = "OBTENER LA LISTA DE REQUESTS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de requests obtenida correctamente",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RequestDTO.class))) }),
            @ApiResponse(responseCode = "404", description = "No se encontraron requests")
    })
    @PostMapping("/getrequests")
    public ResponseEntity<List<RequestDTO>> getRequests() {
        List<Request> requests = requestRepository.findAll();
        List<RequestDTO> requestDTOs = requests.stream().map(request -> {
            RequestDTO dto = new RequestDTO();
            dto.setUserId(request.getUserId() != null ? request.getUserId().getId() : null);
            dto.setPasanakuId(request.getPasanakuId() != null ? request.getPasanakuId().getId() : null);
            dto.setMessage(request.getMessage());
            dto.setState(request.getState());
            dto.setDate(request.getDate());
            dto.setPasanakuName(request.getPasanakuId() != null ? request.getPasanakuId().getName() : null);
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(requestDTOs);
    }

    @Operation(summary = "HU # GP-06 GESTION DE SOLICITUDES - ACEPTAR")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud aceptada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró la solicitud")
    })
    @PostMapping("/acceptrequest")
    public ResponseEntity<String> acceptRequest(@RequestBody Map<String, Long> requestMap){
        Long requestId = requestMap.get("requestId");
        Request request = requestRepository.findById(requestId).orElse(null);
        if (request == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
        }
        request.setState(true);
        requestRepository.save(request);
        return ResponseEntity.status(HttpStatus.OK).body("Request accepted correctly");
    }


    @Operation(summary = "HU # GP-06 GESTION DE SOLICITUDES - DENEGAR")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Solicitud denegada y eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró la solicitud")
    })
    @PostMapping("/denyrequest")
    public ResponseEntity<?> denyRequest(@RequestBody Map<String, Long> requestMap){
        Long requestId = requestMap.get("requestId");
        Request request = requestRepository.findById(requestId).orElse(null);
        if (request == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found");
        }
        requestRepository.delete(request);
        return ResponseEntity.status(HttpStatus.OK).body("Request deleted successfully");
    }


    @Operation(summary = "HU # GP-10 ENVIO DE SOLICITUD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitud enviada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró el Pasanaku asociado a la solicitud")
    })
    @PostMapping("/sendrequest")
    public ResponseEntity<?> sendRequestFromPlayer(@RequestBody RequestDTO requestDTO){
        Request request = new Request();
        request.setMessage(requestDTO.getMessage());
        request.setDate(requestDTO.getDate());
        request.setState(requestDTO.getState());
        //User user = userRepository.findById(requestDTO.getUserId()).orElse(null);
        //request.setUserId(user);
        Pasanaku pasanaku = pasanakuRepository.findById(requestDTO.getPasanakuId()).orElse(null);
        request.setPasanakuId(pasanaku);

        Request savedRequest = requestRepository.save(request);

        requestDTO.setPasanakuName(savedRequest.getPasanakuId().getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(requestDTO);
    }
    
}
