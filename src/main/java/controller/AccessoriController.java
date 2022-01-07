/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.Accessori;
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
import service.AccessoriService;

/**
 * Controller Accessori
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/accessori")
public class AccessoriController {
    
    @Autowired
    private AccessoriService accessoriService;
    
    /**
     * Metode constructor per defecte
     */
    public AccessoriController(){
        
    }
    
    /**
     * Metode per obtenir el Service
     * @param accessoriService Objecte de la classe AccessoriService
     */
    public AccessoriController(AccessoriService accessoriService){
        this.accessoriService = accessoriService;
    }
    
    /**
     * Metode que fa el get de tots el Accessoris de la BBDD
     * @return accessoriService amb tots els Accessoris de la BBDD
     */
    @GetMapping("/getAccessoris")
    public List<Accessori> cercarTotsElsAccessoris(){
        return accessoriService.cercarTotsElsAccessoris();
    }
    
    /**
     * Metode que retorna el accessori per nom (GET)
     * @param nom del accessori a cercar
     * @return el accessori cercat
     */
    @GetMapping("/getAccessoriNom/{nom}")
    public Accessori cercarAccessoriPerNom(@PathVariable String nom){
        Accessori accessori = accessoriService.cercarAccessoriPerNom(nom);
        return accessori;
    }
    
    /**
     * Metode per afegir un accessori (POST)
     * @param accessori que s'introdueix a la base de dades
     */
    @RequestMapping(value= "/addAccessori", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearAccessori(@RequestBody @Valid Accessori accessori){
        accessoriService.crearAccessori(accessori);
    }
    
    /**
     * Metode per modificar un accessori (PUT)
     * @param accessori que volem modificar
     * @return el accessori modificat
     */
    @PutMapping("/modifyAccessori")
    public Accessori editarAccessori(@RequestBody @Valid Accessori accessori){
        Accessori accessoriR = accessoriService.editarAccessori(accessori);
        return accessoriR;
    }
    
    /**
     * Metode per eliminar un Accessori (DELETE)
     * @param accessori que eliminarem
     */
    @DeleteMapping("/deleteAccesori")
    public void eliminarAccessori(@RequestBody @Valid Accessori accessori){
        accessoriService.eliminarAccessori(accessori);
    }
}
