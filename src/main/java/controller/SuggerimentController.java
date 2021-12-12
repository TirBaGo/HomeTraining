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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/suggeriment")
public class SuggerimentController {
    
    @Autowired
    private SuggerimentService suggerimentService;
    
        public SuggerimentController(){
        
    }
    public SuggerimentController(SuggerimentService suggerimentService){
        this.suggerimentService = suggerimentService;
    }
    
    @GetMapping("/getSuggeriments")
    public List<Suggeriment> cercarTotsElsSuggeriments(){
        return suggerimentService.cercarTotsElsSuggeriments();
    }
    
    @GetMapping("/getSuggerimentDNIUsuari/{dni_usuari}")
     public List<Suggeriment> cercarSuggerimentPerDNIUsuari(@PathVariable String dni_usuari){
        List <Suggeriment> suggeriment = suggerimentService.cercarSuggerimentPerDNIUsuari(dni_usuari);
        return suggeriment;
     }
    
    @GetMapping("/getSuggerimentPerIdSuggeriment/{id_suggeriment}")
    public Suggeriment cercarSuggerimentPerIdSuggeriment(@PathVariable int id_suggeriment ){
        Suggeriment suggeriment = suggerimentService.cercarSuggerimentPerIdSuggeriment(id_suggeriment);
        return suggeriment;
    }
    
    @GetMapping("/getSuggerimentPerNom/{nom}")
    public Suggeriment cercarSuggerimentPerNom(@PathVariable String nom){
        Suggeriment suggeriment = suggerimentService.cercarSuggerimentPerNom(nom);
        return suggeriment;
    }
    
    @RequestMapping(value="/addSuggeriment", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearSuggeriment (@RequestBody Suggeriment suggeriment){
        suggerimentService.crearSuggeriment(suggeriment);

    }
    
    @PutMapping("/modifySuggeriment")
    public Suggeriment editarSuggeriment(@RequestBody Suggeriment suggeriment){
        Suggeriment suggerimentR = suggerimentService.editarSuggeriment(suggeriment);
        return suggerimentR;
    }
    
    @DeleteMapping("/deleteSuggeriment")
    public void eliminarSuggeriment(Suggeriment suggeriment){
        suggerimentService.eliminarSuggeriment(suggeriment);
    }
   
    
    
}
