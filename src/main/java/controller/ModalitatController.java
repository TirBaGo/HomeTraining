/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.Modalitat;
import model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ModalitatService;
/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/modalitat")
public class ModalitatController {
     @Autowired
    private ModalitatService modalitatService;
    public ModalitatController() {
    }
 
    public ModalitatController(ModalitatService modalitatService) {
        this.modalitatService = modalitatService;
    }
    
    @GetMapping("/getModalitat")
    public List<Modalitat> cercarTotesLesModalitats() {
        return modalitatService.cercarTotesLesModalitats();
    }
    
    @GetMapping("/getModalitatNom/{nom}")
    public  Modalitat cercarModalitatPerNom(@PathVariable String nom){
         Modalitat modalitat = modalitatService.cercarModalitatPerNom(nom);
        return modalitat;  
    }
    
    @RequestMapping(value="/addModalitat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearModalitat(@RequestBody @Valid  Modalitat modalitat){
        modalitatService.crearModalitat(modalitat);   
    }
    
    @PutMapping("/modifyModalitat")
    public Modalitat editatModalitat(@RequestBody Modalitat modalitat) {
        Modalitat modalitatR = modalitatService.editatModalitat(modalitat);
        
        return modalitatR;
    }
    
    @DeleteMapping("/deleteModalitat")
    public void eliminarModalitat(@RequestBody Modalitat modalitat) {
        modalitatService.eliminarModalitat(modalitat);
    }
}
