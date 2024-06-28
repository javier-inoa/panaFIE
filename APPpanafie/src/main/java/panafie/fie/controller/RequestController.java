/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import panafie.fie.model.request.Request;

import panafie.fie.repository.PasanakuRepository;
import panafie.fie.repository.RequestRepository;
import panafie.fie.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apipanafie")
public class RequestController {
    private final PasanakuRepository pasanakuRepository;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    
    //HU # GP-06 GESTION DE SOLICITUDES
    
    
    //HU # GP-10 ENVIO DE SOLICITUD
    @PostMapping("/sendrequest")
    public ResponseEntity<?> sendRequestFromPlayer(@RequestBody Request createRequest){
        Request savedRequest = requestRepository.save(createRequest);
        return new ResponseEntity.status(HttpStatus.CREATED).body(savedRequest).build();
        
    }
    
}
