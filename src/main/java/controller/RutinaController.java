/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.Rutina;
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
import service.RutinaService;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/rutina")
public class RutinaController {
    @Autowired
    private RutinaService rutinaService;
    public RutinaController(){
        
    }
    public RutinaController(RutinaService rutinaService){
        this.rutinaService = rutinaService;
    }
    
    
    @GetMapping("/getRutines")
    public List<Rutina> cercarTotesLesRutines(){
        return rutinaService.cercarTotesLesRutines();
    }
    
    @GetMapping("/getRutinaDNIEntrenador/{dni_entrenador}")
    public List<Rutina> cercarRutinaPerDniEnterenador(@PathVariable String dni_entrenador){
        List<Rutina> rutina = rutinaService.cercarRutinaPerDniEnterenador(dni_entrenador);
        return rutina;
    }
    
    @GetMapping("/getRutinaModalitat/{nom_modalitat}")
    public List<Rutina> cercarRutinaPerModalitat(@PathVariable String nom_modalitat){
        List<Rutina> rutina = rutinaService.cercarRutinaPerModalitat(nom_modalitat);
        return rutina;
    }
    
    @GetMapping("/getRutinaAccessori/{nom_accessori}")
    public List<Rutina> cercarRutinaPerAccessori(@PathVariable String nom_accessori){
        List<Rutina> rutina = rutinaService.cercarRutinaPerAccessori(nom_accessori);
        return rutina;
    }
    
    @GetMapping("/getRutinaActiva")
    public List<Rutina> cercarRutinaActiva(){
        List<Rutina> rutina = rutinaService.cercarRutinaActiva();
        return rutina;
    }
    
    @GetMapping("/getRutinaNivell/{nivell}")
    public List<Rutina> cercarRutinaNivell(@PathVariable int nivell){
        List<Rutina> rutina = rutinaService.cercarRutinaNivell(nivell);
        return rutina;
    }
    
    @GetMapping("/getRutinaDuracio/{duracio}")
    public List<Rutina> cercarRutinaDuracio(@PathVariable int duracio){
        List<Rutina> rutina = rutinaService.cercarRutinaDuracio(duracio);
        return rutina;
    }
    
    @GetMapping("/getRutinaNom/{nom}")
    public Rutina cercarRutinaPerNom(@PathVariable String nom){
        Rutina rutina = rutinaService.cercarRutinaPerNom(nom);
        return rutina;
    }
    
    @GetMapping("/getRutinaPreu/{preu}")
    public List<Rutina> cercarRutinaPreu(@PathVariable double preu){
        List<Rutina> rutina = rutinaService.cercarRutinaPreu(preu);
        return rutina;
        
    }
    
    @RequestMapping(value="/addRutina", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearRutina(@RequestBody @Valid Rutina rutina){
        rutinaService.crearRutina(rutina);
    }
    
    @PutMapping("/modifyRutina")
    public Rutina editarRutina(@RequestBody  Rutina rutina){
        Rutina rutinaR = rutinaService.editarRutina(rutina);
        return rutinaR;
        
    }
    
    @DeleteMapping("/deleteRutina")
    public void eliminarRutina(@RequestBody Rutina rutina){
        rutinaService.eliminarRutina(rutina);
    }
    
}
