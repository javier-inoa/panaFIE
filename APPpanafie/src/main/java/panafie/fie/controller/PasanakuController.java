/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panafie.fie.dto.PasanakuDTO;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.service.PasanakuService;

@RestController
@RequestMapping("/api/pasanakus")
public class PasanakuController {
    @Autowired
    private PasanakuService pasanakuService;
    
    @PostMapping
    public ResponseEntity<Pasanaku>createPasanaku(@RequestBody PasanakuDTO pasanakuDTO){
        Pasanaku pasanaku = new Pasanaku();
       pasanaku.setName(pasanakuDTO.getName());
       
       
       Pasanaku savedPasanaku = pasanakuService.savePasanaku(pasanaku);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedPasanaku);
    }
}
