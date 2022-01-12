/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import model.Inscripcio;
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
import service.InscripcioService;

/**
 * Controller de Inscripcio
 * @author Nerea Gallardo
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/inscripcio")
public class InscripcioController {
    
    @Autowired
    private InscripcioService inscripcioService;

    public InscripcioController() {
    }
    
    public InscripcioController(InscripcioService inscripcioService) {
        this.inscripcioService = inscripcioService;
    }
    


    /**
     * Metode que cerca inscripcions per dni (GET)
     * @param dni que es vol cercar
     * @return inscripcions amb el dni indicat
     */
    @GetMapping("/getInscripcioDNI/{dni}")
    public List<Inscripcio> cercarInscripcioPerDNI(@PathVariable String dni) {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerDNI(dni);
        return inscripcio;
    }

    /**
     * Metode que cerca una inscripcio per id (GET)
     * @param id_inscripcio que es vol cercar
     * @return inscripcio amb l'id indicat
     */
    @GetMapping("/getInscripcioId/{id_inscripcio}")
    public Inscripcio cercarInscripcioPerId(@PathVariable int id_inscripcio) {
        Inscripcio inscripcio = inscripcioService.cercarInscripcioPerId(id_inscripcio);
        return inscripcio;
    }

    /**
     * Metode que cerca inscripcions per nom rutina (GET)
     * @param nom_rutina que es vol cercar
     * @return inscripcions amb el nom rutina indicat
     */
    @GetMapping("/getInscripcioNomRutina/{nom_rutina}")
    public List<Inscripcio> cercarInscripcioPerNomRutina(@PathVariable String nom_rutina) {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerNomRutina(nom_rutina);
        return inscripcio;
    }

    /**
     * MEtode que cerca inscripcions amb is pagat true (GET)
     * @return inscripcions que tinguin pagat en true
     */
    @GetMapping("/getInscripcioIspagat")
    public List<Inscripcio> cercarInscripcioPerIspagat() {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerIspagat();
        return inscripcio;
    }

    /**
     * Metode que cerca inscripcions amb is pagat false (GET)
     * @return inscripcions que tinguin pagat en false
     */
    @GetMapping("/getInscripcioIspagatFalse")
    public List<Inscripcio> cercarInscripcioPerFalseIspagat() {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerFalseIspagat();
        return inscripcio;
    }

    /**
     * Metode que cerca inscripcions per data d'alta (GET)
     * @param data_alta que es vol cercar
     * @return inscripcions amb la data indicada
     */
    @GetMapping("/getInscripcioDataAlta/{data_alta}")
    public List<Inscripcio> cercarInscripcioPerDataAlta(@PathVariable Timestamp data_alta) {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerDataAlta(data_alta);
        return inscripcio;
    }

    /**
     * MEtode que cerca inscripcions per data fi (GET)
     * @param data_fi que es vol cercar
     * @return Inscripcions amb la data indicada
     */
    @GetMapping("/getInscripcioDataFi/{data_fi}")
    public List<Inscripcio> cercarInscripcioPerDataFi(@PathVariable Timestamp data_fi) {
        List<Inscripcio> inscripcio = inscripcioService.cercarInscripcioPerDataFi(data_fi);
        return inscripcio;
    }

    /**
     * Metode que cerca totes les inscripcions (GET)
     * @return totes les inscripcions
     */
    @GetMapping("/getInscripcions")
    public List<Inscripcio> cercarTotesLesInscripcions() {
        return inscripcioService.cercarTotesLesInscripcions();
    }
    
    /**
     * Metode que crea una inscripcio (POST)
     * @param inscripcio que es vol crear
     */
    @RequestMapping(value="/addInscripcio", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void crearInscripcio(@RequestBody @Valid Inscripcio inscripcio) {
        inscripcioService.crearInscripcio(inscripcio);
    }

    /**
     * Metode que edita una inscripcio(PUT)
     * @param inscripcio que es vol crear
     * @return inscripcio editada
     */
    @PutMapping("/modifyInscripcio")
    public Inscripcio editarInscripcio(@RequestBody @Valid Inscripcio inscripcio) {
        Inscripcio inscripcioR = inscripcioService.editarInscripcio(inscripcio);
        return inscripcioR;
    }

    /**
     * Metode que elimina una inscripcio(DELETE)
     * @param inscripcio que es vol crear
     */
    @DeleteMapping("/deleteInscripcio")
    public void eliminarInscripcio(@RequestBody @Valid Inscripcio inscripcio) {
        inscripcioService.eliminarInscripcio(inscripcio);
    }
}
