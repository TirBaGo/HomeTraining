/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Queixes;
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
import service.QueixesService;

/**
 * Controller de Queixes
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/queixes")
public class QueixesController {
    
    @Autowired
    private QueixesService queixesService;
    
    /**
     * Metode constructor per defecte
     */
    public QueixesController(){
        
    }

    /**
     * Metode que agafa el Service de queixes
     * @param queixesService Objecte de QueixesService
     */
    public QueixesController(QueixesService queixesService){
        this.queixesService = queixesService;
    }
    
    /**
     * Metode que retorna totes les queixes (GET)
     * @return Totes les queixes de la BBDD
     */
    @GetMapping("/getQueixes")
    public List<Queixes> cercarTotesLesQueixes(){
        return queixesService.cercarTotesLesQueixes();
    }
    
    /**
     * Metode que cerca les queixes per un DNI (GET)
     * @param dni_usuari del usuari que ha creat les quixes
     * @return les queixes assocciades al dni passar per parametre
     */
    @GetMapping("/getQueixaDNIUsuari/{dni_usuari}")
    public List<Queixes> cercarQueixesPerDNIUsuari(@PathVariable String dni_usuari){
        List<Queixes> queixes = queixesService.cercarQueixaPerDNIUsuari(dni_usuari);
        return queixes;
    }
    
    /**
     * Metode que cerca les queixes per la seva ID (GET)
     * @param id_queixes id que es vol cercar
     * @return la queixa que coincideix amb l'id pasar per parametre
     */
    @GetMapping("/getQueixesPerIdQueixes/{id_queixes}")
    public Queixes cercarQueixaPerIdQueixes(@PathVariable int id_queixes){
        Queixes queixes = queixesService.cercarQueixaPerIdQueixes(id_queixes);
        return queixes;
    }
    
    /**
     * Metode que cerca per el nom de la queixa (GET)
     * @param nom de la queixa que es vol cercar
     * @return la queixa que coincideix amb el nom pasat per parametre
     */
    @GetMapping("/getQueixesPerNom/{nom}")
    public Queixes cercarQueixaPerNom(@PathVariable String nom){
        Queixes queixes = queixesService.cercarQueixaPerNom(nom);
        return queixes;
    }
    
    /**
     * Metode que crea la queixa (POST)
     * @param queixes que es vol crear a la BBDD
     */
    @RequestMapping(value="/addQueixes", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearQueixa(@RequestBody Queixes queixes){
        queixesService.crearQueixa(queixes);
    }
    
    /**
     * Metode que modifica la queixa indicada (PUT)
     * @param queixes que es vol modificar
     * @return la queixa pasada per parametre modificada
     */
    @PutMapping("/modifyQueixa")
    public Queixes modificarQueixes(@RequestBody Queixes queixes){
        Queixes queixesR = queixesService.editarQueixa(queixes);
        return queixesR;
    }
    
    /**
     * Metode que elimina la quixa indicada (DELETE)
     * @param queixes que es vol eliminar de la BBDD
     */
    @DeleteMapping("/deleteQueixa")
    public void eliminarQueixa(@RequestBody Queixes queixes){
        queixesService.eliminarQueixa(queixes);
    }
}
