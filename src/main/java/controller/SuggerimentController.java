/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Suggeriment;
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
import service.SuggerimentService;

/**
 * Controller de suggeriment
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/suggeriment")
public class SuggerimentController {
    
    @Autowired
    private SuggerimentService suggerimentService;
    
    /**
     * Metode constructor per defecte
     */
    public SuggerimentController(){
        
    }

    /**
     * Metode que agafa el Service de Suggeriment
     * @param suggerimentService objecte de SuggerimentService
     */
    public SuggerimentController(SuggerimentService suggerimentService){
        this.suggerimentService = suggerimentService;
    }
    
    /**
     * Metode que retorna tots els suggeriments (GET)
     * @return tots els suggeriments
     */
    @GetMapping("/getSuggeriments")
    public List<Suggeriment> cercarTotsElsSuggeriments(){
        return suggerimentService.cercarTotsElsSuggeriments();
    }
    
    /**
     * Metode que retorna els suggeriments per el dni (GET)
     * @param dni_usuari de l'usuari que crea els suggeriments
     * @return els suggeriments assocciats al dni passsat per parametre
     */
    @GetMapping("/getSuggerimentDNIUsuari/{dni_usuari}")
     public List<Suggeriment> cercarSuggerimentPerDNIUsuari(@PathVariable String dni_usuari){
        List <Suggeriment> suggeriment = suggerimentService.cercarSuggerimentPerDNIUsuari(dni_usuari);
        return suggeriment;
     }
    
    /**
     * Metode que retorna el suggeriment per el seu ID (GET)
     * @param id_suggeriment del suggeriment que es vol cercar
     * @return el suggeriment que coiencideix amb el id pasat per paramtre
     */
    @GetMapping("/getSuggerimentPerIdSuggeriment/{id_suggeriment}")
    public Suggeriment cercarSuggerimentPerIdSuggeriment(@PathVariable int id_suggeriment ){
        Suggeriment suggeriment = suggerimentService.cercarSuggerimentPerIdSuggeriment(id_suggeriment);
        return suggeriment;
    }
    
    /** 
     * Metode que retorna el suggeriment per le seu nom (GET)
     * @param nom del suggeriment que es vol cercar
     * @return el suggeriment amb el nom indicat per parametre
     */
    @GetMapping("/getSuggerimentPerNom/{nom}")
    public Suggeriment cercarSuggerimentPerNom(@PathVariable String nom){
        Suggeriment suggeriment = suggerimentService.cercarSuggerimentPerNom(nom);
        return suggeriment;
    }
    
    /**
     * Metode que crea el suggeriment (POST)
     * @param suggeriment que es vol introduir a la base de dades
     */
    @RequestMapping(value="/addSuggeriment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearSuggeriment (@RequestBody Suggeriment suggeriment){
        suggerimentService.crearSuggeriment(suggeriment);

    }
    
    /**
     * Metode que modifica el suggeriment pasat per parametre (PUT)
     * @param suggeriment que es vol modificar
     * @return el suggeriment modificat
     */
    @PutMapping("/modifySuggeriment")
    public Suggeriment editarSuggeriment(@RequestBody Suggeriment suggeriment){
        Suggeriment suggerimentR = suggerimentService.editarSuggeriment(suggeriment);
        return suggerimentR;
    }
    
    /**
     * Metode que elimina un suggeriment (DELETE)
     * @param suggeriment que es vol eliminar
     */
    @DeleteMapping("/deleteSuggeriment")
    public void eliminarSuggeriment(Suggeriment suggeriment){
        suggerimentService.eliminarSuggeriment(suggeriment);
    }
   
    
    
}
