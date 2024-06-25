/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panafie.fie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panafie.fie.model.pasanaku.Pasanaku;
import panafie.fie.repository.PasanakuRepository;

@Service
public class PasanakuService {
    
    @Autowired
    private PasanakuRepository pasanakuRepository;
    
    public Pasanaku savePasanaku(Pasanaku pasanaku){
        return pasanakuRepository.save(pasanaku);
    }
    
}
