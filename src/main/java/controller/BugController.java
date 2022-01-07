/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Bug;
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
import service.BugService;

/**
 * Controller de Bug
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/bug")
public class BugController {
    @Autowired
    private BugService bugService;

    /**
     * Metode constructor per defecte
     */
    public BugController() {
    }
    
    /**
     * Metode que agafa el BugService
     * @param bugService objecte de la classe bugService
     */
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }
    
    /**
     * Metode que retorna tots els bugs (GET)
     * @return el bugService amb tots el bugs de la BBDD
     */
    @GetMapping("/getBugs")
    public List<Bug> cercarTotsElsBugs(){
        return bugService.cercarTotsElsBugs();
    }
    
    /**
     * Metode que retorna els bugs per DNI del creador(GET)
     * @param dni_usuari de l'usuari que ha creat el bug
     * @return els bugs que coincideixen amb el DNI
     */
    @GetMapping("/getBugDNIUsuari/{dni_usuari}")
    public List<Bug> cercarBugPerDNIUsuari(@PathVariable String dni_usuari){
        List<Bug> bug = bugService.cercarBugPerDNIUsuari(dni_usuari);
        return bug;
    }
    
    /**
     * MEtode que retorna el bug per id (GET)
     * @param id_bug del bug que es vol cercar
     * @return el bug cercat per id
     */
    @GetMapping("/getBugPerIdBug/{id_bug}")
    public Bug cercarBugPerIdBug(@PathVariable int id_bug){
        Bug bug = bugService.cercarBugPerIdBug(id_bug);
        return bug;
    }
    
    /**
     * Metode que retorna el bug per el nom (GET)
     * @param nom del bug que volem cercar
     * @return el bug amb el nom cercat
     */
    @GetMapping("/getBugPerNom/{nom}")
    public Bug cercarBugPerNom(@PathVariable String nom){
        Bug bug = bugService.cercarBugPerNom(nom);
        return bug;
    }
    
    /**
     * Metode que crea el bug (POST)
     * @param bug que es vol introduir en la base de dades
     */
    @RequestMapping(value="/addBug", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearBug(@RequestBody Bug bug){
        bugService.crearBug(bug);
    }
    
    /**
     * Metode que modifica un bug existent (PUT)
     * @param bug que rebem per modificar
     * @return el bug modificat
     */
    @PutMapping("/modifyBug")
    public Bug modificarBug(@RequestBody Bug bug){
        Bug bugR = bugService.editarBug(bug);
        return bugR;
    }
    
    /**
     * Metode que elimina un bug
     * @param bug que volem eliminar
     */
    @DeleteMapping("/deleteBug")
    public void eliminarBug(@RequestBody Bug bug){
        bugService.eliminarBug(bug);
    }
    
}
