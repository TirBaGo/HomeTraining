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
 * Controller de rutina
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/rutina")
public class RutinaController {
    @Autowired
    private RutinaService rutinaService;

    /**
     * Metode constructor per defecte
     */
    public RutinaController(){
        
    }

    /**
     * Metode que agafa el Service que Rutina
     * @param rutinaService objecte de rutinaService
     */
    public RutinaController(RutinaService rutinaService){
        this.rutinaService = rutinaService;
    }
    
    /**
     * Metode que retorna totes les rutines (GET)
     * @return totes les rutines de la BBDD
     */
    @GetMapping("/getRutines")
    public List<Rutina> cercarTotesLesRutines(){
        return rutinaService.cercarTotesLesRutines();
    }
    
    /**
     * Metode que retorna les rutinas per el dni de l'entrenador (GET)
     * @param dni_entrenador que ha creat la rutina
     * @return les rutines assocciades al dni de l'entrenador passat per parametre
     */
    @GetMapping("/getRutinaDNIEntrenador/{dni_entrenador}")
    public List<Rutina> cercarRutinaPerDniEnterenador(@PathVariable String dni_entrenador){
        List<Rutina> rutina = rutinaService.cercarRutinaPerDniEnterenador(dni_entrenador);
        return rutina;
    }
    
    /**
     * Metode que retorna la rutina per el nom de la modalitat (GET)
     * @param nom_modalitat nom de la modalitat 
     * @return les rutines que tenen la modalitat indicada per parametre
     */
    @GetMapping("/getRutinaModalitat/{nom_modalitat}")
    public List<Rutina> cercarRutinaPerModalitat(@PathVariable String nom_modalitat){
        List<Rutina> rutina = rutinaService.cercarRutinaPerModalitat(nom_modalitat);
        return rutina;
    }
    
    /**
     * Metode que retona les rutines amb el nom de l'accessori indicat (GET)
     * @param nom_accessori nom de l'accessori
     * @return les rutines que que tenen el accessori indicat per parametre
     */
    @GetMapping("/getRutinaAccessori/{nom_accessori}")
    public List<Rutina> cercarRutinaPerAccessori(@PathVariable String nom_accessori){
        List<Rutina> rutina = rutinaService.cercarRutinaPerAccessori(nom_accessori);
        return rutina;
    }
    
    /**
     * Metode que retorna les rutines actives (GET)
     * @return les rutines amb active true
     */
    @GetMapping("/getRutinaActiva")
    public List<Rutina> cercarRutinaActiva(){
        List<Rutina> rutina = rutinaService.cercarRutinaActiva();
        return rutina;
    }
    
    /**
     * Metode que retorna les rutines segons el seu nivell (GET)
     * @param nivell de la rutina que es vol cercar 
     * @return les rutines que coincideixen amb el nivell indicat
     */
    @GetMapping("/getRutinaNivell/{nivell}")
    public List<Rutina> cercarRutinaNivell(@PathVariable int nivell){
        List<Rutina> rutina = rutinaService.cercarRutinaNivell(nivell);
        return rutina;
    }
    
    /**
     * Metode que retorna les rutines segons la seva duracio (GET)
     * @param duracio de la rutina que es vol cercar
     * @return rutines que coincideixen amb la duracio indicada
     */
    @GetMapping("/getRutinaDuracio/{duracio}")
    public List<Rutina> cercarRutinaDuracio(@PathVariable int duracio){
        List<Rutina> rutina = rutinaService.cercarRutinaDuracio(duracio);
        return rutina;
    }
    
    /**
     * Metode que retorna la rutina amb el nom indicat (GET)
     * @param nom de la rutina que es vol cercar
     * @return la rutina amb el nom indicat
     */
    @GetMapping("/getRutinaNom/{nom}")
    public Rutina cercarRutinaPerNom(@PathVariable String nom){
        Rutina rutina = rutinaService.cercarRutinaPerNom(nom);
        return rutina;
    }
    
    /**
     * Metode que retorna les rutins amb el preu indicat (GET)
     * @param preu que es vol cercar
     * @return les rutines amb el preu passat per parametre
     */
    @GetMapping("/getRutinaPreu/{preu}")
    public List<Rutina> cercarRutinaPreu(@PathVariable double preu){
        List<Rutina> rutina = rutinaService.cercarRutinaPreu(preu);
        return rutina;
        
    }
    
    /**
     * Metode que crea la rutina pasada pr parametre (POST)
     * @param rutina que es vol crear a la BBDD
     */
    @RequestMapping(value="/addRutina", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearRutina(@RequestBody @Valid Rutina rutina){
        rutinaService.crearRutina(rutina);
    }
    
    /**
     * Metode que modifica la rutina indicada (PUT)
     * @param rutina que es vol modificar
     * @return rutina modificada
     */
    @PutMapping("/modifyRutina")
    public Rutina editarRutina(@RequestBody  Rutina rutina){
        Rutina rutinaR = rutinaService.editarRutina(rutina);
        return rutinaR;
        
    }
    
    /**
     * Metode que elimina la rutina indicada (DELETE)
     * @param rutina que es vol eliminar
     */
    @DeleteMapping("/deleteRutina")
    public void eliminarRutina(@RequestBody Rutina rutina){
        rutinaService.eliminarRutina(rutina);
    }
    
}
