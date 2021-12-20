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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/bug")
public class BugController {
    @Autowired
    private BugService bugService;

    public BugController() {
    }
    
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }
    
    @GetMapping("/getBugs")
    public List<Bug> cercarTotsElsBugs(){
        return bugService.cercarTotsElsBugs();
    }
    
    @GetMapping("/getBugDNIUsuari/{dni_usuari}")
    public List<Bug> cercarBugPerDNIUsuari(@PathVariable String dni_usuari){
        List<Bug> bug = bugService.cercarBugPerDNIUsuari(dni_usuari);
        return bug;
    }
    
    @GetMapping("/getBugPerIdBug/{id_bug}")
    public Bug cercarBugPerIdBug(@PathVariable int id_bug){
        Bug bug = bugService.cercarBugPerIdBug(id_bug);
        return bug;
    }
    
    @GetMapping("/getBugPerNom/{nom}")
    public Bug cercarBugPerNom(@PathVariable String nom){
        Bug bug = bugService.cercarBugPerNom(nom);
        return bug;
    }
    
    @RequestMapping(value="/addBug", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearBug(@RequestBody Bug bug){
        bugService.crearBug(bug);
    }
    
    @PutMapping("/modifyBug")
    public Bug modificarBug(@RequestBody Bug bug){
        Bug bugR = bugService.editarBug(bug);
        return bugR;
    }
    
    @DeleteMapping("/deleteBug")
    public void eliminarBug(@RequestBody Bug bug){
        bugService.eliminarBug(bug);
    }
    
    
}
