/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Dubte;
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
import service.DubteService;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/dubte")
public class DubteController {
    
    @Autowired
    private DubteService dubteService;
    
    public DubteController(){
        
    }
    public DubteController(DubteService dubteService){
        this.dubteService = dubteService;
    }
    
        @GetMapping("/getDubtes")
    public List<Dubte> cercarTotsElsDubtes(){
        return dubteService.cercarTotsElsDubtes();
    }
    
    @GetMapping("/getDubteDNIUsuari/{dni_usuari}")
    public List<Dubte> cercarDubtePerDNIUsuari(@PathVariable String dni_usuari){
        List<Dubte> dubte = dubteService.cercarDubtePerDNIUsuari(dni_usuari);
        return dubte;
    }
    
    @GetMapping("/getDubtePerIdDubte/{id_dubte}")
    public Dubte cercarDubtePerIdDubte(@PathVariable int id_dubte){
        Dubte dubte = dubteService.cercarDubtePerIdDubte(id_dubte);
        return dubte;
    }
    
    @GetMapping("/getDubtePerNom/{nom}")
    public Dubte cercarDubtePerNom(@PathVariable String nom){
        Dubte dubte = dubteService.cercarDubtePerNom(nom);
        return dubte;
    }
    
    @RequestMapping(value="/addDubte", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearDubte(@RequestBody Dubte dubte){
        dubteService.crearDubte(dubte);
    }
    
    @PutMapping("/modifyDubte")
    public Dubte modificarDubte(@RequestBody Dubte dubte){
        Dubte dubteR = dubteService.editarDubte(dubte);
        return dubteR;
    }
    
    @DeleteMapping("/deleteDubte")
    public void eliminarDubte(@RequestBody Dubte dubte){
        dubteService.eliminarDubte(dubte);
    }
      
    
}
