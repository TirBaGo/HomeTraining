/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.Modalitat;
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
 * Controller de Modalitat
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/modalitat")
public class ModalitatController {
    
    @Autowired
    private ModalitatService modalitatService;
    
    /**
     * Metode constructor per defecte
     */
    public ModalitatController(){
        
    }
    
    /**
     * Metode que agafa el Service de modalitat
     * @param modalitatService Objecte de modalitatService
     */
    public ModalitatController(ModalitatService modalitatService){
        this.modalitatService = modalitatService;
    }
    
    /**
     * Metode que retorna totes les modalitats (GET)
     * @return totes les modalitats de la BBDD
     */
    @GetMapping("/getModalitats")
    public List<Modalitat> cercarTotesLesModalitats(){
        return modalitatService.cercarTotesLesModalitats();
    }
    
    /**
     * Metode que retorna la modalitat amb el nom indicat (GET)
     * @param nom de la modalitat a cercar
     * @return modalitat amb el nom passat per parametre
     */
    @GetMapping("/getModalitatNom/{nom}")
    public Modalitat cercarModalitatPerNom(@PathVariable String nom){
        Modalitat modalitat = modalitatService.cercarModalitatPerNom(nom);
        return modalitat;
    }
    
    /** 
     * Metode que crea la modailitat (POST)
     * @param modalitat que es vol crear a la BBDD
     */
    @RequestMapping(value = "/addModalitat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearModalitat(@RequestBody @Valid Modalitat modalitat){
        modalitatService.crearModalitat(modalitat);
    }
    
    /**
     * Metode que modifica la modalitat (PUT)
     * @param modalitat que es vol modificar
     * @return modalitat modificada
     */
    @PutMapping("/modifyModalitat")
    public Modalitat editarModalitat(@RequestBody @Valid Modalitat modalitat){
        Modalitat modalitatR = modalitatService.editarModalitat(modalitat);
        return modalitatR;
    }
    
    /**
     * Metode que elimina una modalitat (DELETE)
     * @param modalitat que es vol eliminar
     */
    @DeleteMapping("/deleteModalitat")
    public void eliminarModalitat(@RequestBody @Valid Modalitat modalitat){
        modalitatService.eliminarModalitat(modalitat);
    }
    
}
