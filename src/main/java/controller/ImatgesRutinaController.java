/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.ImatgesRutina;
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
import service.ImatgesRutinaService;

/**
 * Controller de imatges_rutina
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/imatgesrutina")
public class ImatgesRutinaController {
    
    @Autowired
    private ImatgesRutinaService imatgesRutinaService;
    
    /**
     * Metode constructor per defecte
     */
    public ImatgesRutinaController (){
        
    }
    
    /**
     * Metode que agafa el Service de imatges_rutina
     * @param imatgesRutinaService objecte de imatgesRutinaService
     */
    public ImatgesRutinaController(ImatgesRutinaService imatgesRutinaService){
       this.imatgesRutinaService = imatgesRutinaService;
    }
    
    /**
     * Metode que retorna totes les imatges_rutina (GET)
     * @return totes les imatges rutina
     */
    @GetMapping("/getImatgesRutina")
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        return imatgesRutinaService.cercarTotesLesImatgesRutina();
    }
    
    /**
     * Metode que retorna la imatge rutina per id (GET)
     * @param id_imatge de l'imatge que es vol cercar
     * @return la imatge per el seu id
     */
    @GetMapping("/getImatgesRutinaIdImatge/{id_imatge}")
    public  ImatgesRutina cercarPerIdImatgesRutina(@PathVariable int id_imatge){
        ImatgesRutina imatgesRutina = imatgesRutinaService.cercarPerIdImatgesRutina(id_imatge);
        return imatgesRutina;  
    }
    
    /**
     * Metode que retorna les imatges amb el mateix id de la rutina enllaçada (GET)
     * @param id_rutina de la rutina asssocciada amb les imatges
     * @return les imatges que tenen el id rutina passat per parametre
     */
    @GetMapping("/getImatgesRutinaIdRutina/{id_rutina}")
    public  List<ImatgesRutina> cercarPerIdRutina(@PathVariable int id_rutina){
        List<ImatgesRutina> imatgesRutina = imatgesRutinaService.cercarPerIdRutina(id_rutina);
        return imatgesRutina;  
    }
    
    /**
     * Metode que crea una imatge rutina (POST)
     * @param imatgesRutina que es vol insertar a la base de dades
     */
    @RequestMapping(value="/addImatgeRutina", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearImatgesRutina(@RequestBody @Valid ImatgesRutina imatgesRutina){
        imatgesRutinaService.crearImatgesRutina(imatgesRutina);   
    }
    
    /**
     * Metode que modifica les imatges_rutina (PUT)
     * @param imatgesRutina que es vol modificar
     * @return la imatgeRutina modificada
     */
    @PutMapping("/modifyImatgeRutina")
    public ImatgesRutina editarImatgesRutina(@RequestBody ImatgesRutina imatgesRutina) {
        ImatgesRutina imatgesRutinaR = imatgesRutinaService.editarImatgesRutina(imatgesRutina);
        return imatgesRutinaR;
    }

    /**
     * Metode per eliminar una imatge rutina (DELETE)
     * @param imatgesRutina que es vol eliminar
     */
    @DeleteMapping("/deleteImatgeRutina")
    public void eliminarImatgesRutina(@RequestBody ImatgesRutina imatgesRutina) {
        imatgesRutinaService.eliminarImatgesRutina(imatgesRutina);
    }
}
