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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/queixes")
public class QueixesController {
    
    @Autowired
    private QueixesService queixesService;
    
    public QueixesController(){
        
    }
    public QueixesController(QueixesService queixesService){
        this.queixesService = queixesService;
    }
    
    @GetMapping("/getQueixes")
    public List<Queixes> cercarTotesLesQueixes(){
        return queixesService.cercarTotesLesQueixes();
    }
    
    @GetMapping("/getQueixaDNIUsuari/{dni_usuari}")
    public List<Queixes> cercarQueixesPerDNIUsuari(@PathVariable String dni_usuari){
        List<Queixes> queixes = queixesService.cercarQueixaPerDNIUsuari(dni_usuari);
        return queixes;
    }
    
    @GetMapping("/getQueixesPerIdQueixes/{id_queixes}")
    public Queixes cercarQueixaPerIdQueixes(@PathVariable int id_queixes){
        Queixes queixes = queixesService.cercarQueixaPerIdQueixes(id_queixes);
        return queixes;
    }
    
    @GetMapping("/getQueixesPerNom/{nom}")
    public Queixes cercarQueixaPerNom(@PathVariable String nom){
        Queixes queixes = queixesService.cercarQueixaPerNom(nom);
        return queixes;
    }
    
    @RequestMapping(value="/addQueixes", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearQueixa(@RequestBody Queixes queixes){
        queixesService.crearQueixa(queixes);
    }
    
    @PutMapping("/modifyQueixa")
    public Queixes modificarQueixes(@RequestBody Queixes queixes){
        Queixes queixesR = queixesService.editarQueixa(queixes);
        return queixesR;
    }
    
    @DeleteMapping("/deleteQueixa")
    public void eliminarQueixa(@RequestBody Queixes queixes){
        queixesService.eliminarQueixa(queixes);
    }
}
