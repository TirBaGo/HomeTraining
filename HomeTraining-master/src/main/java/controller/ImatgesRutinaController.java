/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.ImatgesRutina;
import model.Usuari;
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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/imatgesrutina")
public class ImatgesRutinaController {
    
    @Autowired
    private ImatgesRutinaService imatgesRutinaService;
    
    public ImatgesRutinaController (){
        
    }
    
    public ImatgesRutinaController(ImatgesRutinaService imatgesRutinaService){
       this.imatgesRutinaService = imatgesRutinaService;
    }
    
    @GetMapping("/getImatgesRutina")
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        return imatgesRutinaService.cercarTotesLesImatgesRutina();
    }
    
    @GetMapping("/getImatgesRutinaIdImatge/{id_imatge}")
    public  ImatgesRutina cercarPerIdImatgesRutina(@PathVariable int id_imatge){
        ImatgesRutina imatgesRutina = imatgesRutinaService.cercarPerIdImatgesRutina(id_imatge);
        return imatgesRutina;  
    }
    
    @GetMapping("/getImatgesRutinaIdRutina/{id_rutina}")
    public  List<ImatgesRutina> cercarPerIdRutina(@PathVariable int id_rutina){
        List<ImatgesRutina> imatgesRutina = imatgesRutinaService.cercarPerIdRutina(id_rutina);
        return imatgesRutina;  
    }
    
    @RequestMapping(value="/addImatgeRutina", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearImatgesRutina(@RequestBody @Valid ImatgesRutina imatgesRutina){
        imatgesRutinaService.crearImatgesRutina(imatgesRutina);   
    }
    
     @PutMapping("/modifyImatgeRutina")
    public ImatgesRutina editarImatgesRutina(@RequestBody ImatgesRutina imatgesRutina) {
        ImatgesRutina imatgesRutinaR = imatgesRutinaService.editarImatgesRutina(imatgesRutina);
        return imatgesRutinaR;
    }

    @DeleteMapping("/deleteImatgeRutina")
    public void eliminarImatgesRutina(@RequestBody ImatgesRutina imatgesRutina) {
        imatgesRutinaService.eliminarImatgesRutina(imatgesRutina);
    }
}
