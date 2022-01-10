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
 * Controller de Dubte
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/dubte")
public class DubteController {
    
    @Autowired
    private DubteService dubteService;
    
    /**
     * Metode constructor per defecte
     */
    public DubteController(){
        
    }

    /**
     * Metode que agafa el dubteService
     * @param dubteService objecte de la classe dubteService
     */
    public DubteController(DubteService dubteService){
        this.dubteService = dubteService;
    }
    
    /**
     * Metode que retorna tots els dubtes (GET)
     * @return tots els dubtes de la BBDD
     */
    @GetMapping("/getDubtes")
    public List<Dubte> cercarTotsElsDubtes(){
        return dubteService.cercarTotsElsDubtes();
    }
    
    /**
     * MEtode que retorna els dubtes creats per un usuari (GET)
     * @param dni_usuari de l'usuari que ha creat el dubte
     * @return els dubtes de l'usuari amb el dni que en passen per parametre
     */
    @GetMapping("/getDubteDNIUsuari/{dni_usuari}")
    public List<Dubte> cercarDubtePerDNIUsuari(@PathVariable String dni_usuari){
        List<Dubte> dubte = dubteService.cercarDubtePerDNIUsuari(dni_usuari);
        return dubte;
    }
    
    /**
     * Metode que retorna el dubte amb l'id passat per parametre (GET)
     * @param id_dubte del dubte que volem cercar
     * @return el dubte amb el id passat per parametre
     */
    @GetMapping("/getDubtePerIdDubte/{id_dubte}")
    public Dubte cercarDubtePerIdDubte(@PathVariable int id_dubte){
        Dubte dubte = dubteService.cercarDubtePerIdDubte(id_dubte);
        return dubte;
    }
    
    /**
     * Metode que retorna el bug cercat pel seu nom (GET)
     * @param nom del dubte que volem cercar
     * @return el dubte amb el nom que ens pasen per parametre
     */
    @GetMapping("/getDubtePerNom/{nom}")
    public Dubte cercarDubtePerNom(@PathVariable String nom){
        Dubte dubte = dubteService.cercarDubtePerNom(nom);
        return dubte;
    }
    
    /**
     * Metode que crea un dubte en la base de dades (POST)
     * @param dubte que es vol introduir en la base de dades
     */
    @RequestMapping(value="/addDubte", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearDubte(@RequestBody Dubte dubte){
        dubteService.crearDubte(dubte);
    }
    
    /**
     * Metode que modifica un dubte existent (PUT)
     * @param dubte que es vol modificar
     * @return el dubte modificat
     */
    @PutMapping("/modifyDubte")
    public Dubte modificarDubte(@RequestBody Dubte dubte){
        Dubte dubteR = dubteService.editarDubte(dubte);
        return dubteR;
    }
    
    /**
     * Metode que elimina un dubte (DELETE)
     * @param dubte que es vol eliminar
     */
    @DeleteMapping("/deleteDubte")
    public void eliminarDubte(@RequestBody Dubte dubte){
        dubteService.eliminarDubte(dubte);
    }
      
    
}
