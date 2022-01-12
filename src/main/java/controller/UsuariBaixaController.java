/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import model.UsuariBaixa;
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
import service.UsuariBaixaService;

/**
 * Controller de UsuariBaixa
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/usuariBaixa")
public class UsuariBaixaController {
    @Autowired
    private UsuariBaixaService usuariBaixaService;

    /**
     * Metode constructor per defecte
     */
    public UsuariBaixaController() {
    }
 
    /**
     * Metode que agafa el Service de usuariBaixa
     * @param usuariBaixaService objecte amb el UsuariBaixaService
     */
    public UsuariBaixaController(UsuariBaixaService usuariBaixaService) {
        this.usuariBaixaService = usuariBaixaService;
    }
    
    /**
     * Metode que retorna tots els usuarisBaixa (GET)
     * @return tots els usuarisBaixa de la base de dades
     */
    @GetMapping("/getUsuarisBaixa")
    public List<UsuariBaixa> cercarTotsElsUsuarisBaixa() {
        return usuariBaixaService.cercarTotsElsUsuarisBaixa();
    }
    
    /**
     * Metode que retorna l'usariBaixa pel seu dni (GET)
     * @param dni de l'usuariBaixa que es vol cercar 
     * @return l'usuariBaixa amb el dni pasat per parametre
     */ 
    @GetMapping("/getUsuariBaixaDNI/{dni}")
    public  UsuariBaixa cercarUsuariBaixaPerDNI(@PathVariable String dni){
        UsuariBaixa usuariBaixa = usuariBaixaService.cercarUsuariBaixaPerDNI(dni);
        return usuariBaixa;  
    }
    
    /**
     * Metode que retorna l'usuariBaixa pel seu nom (GET)
     * @param nom de l'usuariBaixa que es vol cercar
     * @return retorna els usuaris Baixa amb el nom pasat per parametre
     */
    @GetMapping("/getUsuariBaixaNom/{nom}")
    public  List<UsuariBaixa> cercarUsuarisBaixaPerNom(@PathVariable String nom){
        List<UsuariBaixa> usuarisBaixa= usuariBaixaService.cercarUsuarisBaixaPerNom(nom);
        return usuarisBaixa;  
    }
    
    /**
     * Metode que retorna els usuariBaixa per data_baixa (GET)
     * @param data_baixa que es vol cercar
     * @return retorna els usuarisBaixa amb la data_baixa indicada
     */
    @GetMapping("/getUsuariDataBaixa/{data_baixa}")
    public  List<UsuariBaixa> cercarUsuariBaixaPerDataBaixa(@PathVariable Timestamp data_baixa){
        List<UsuariBaixa> usuarisBaixa = usuariBaixaService.cercarUsuariBaixaPerDataBaixa(data_baixa);
        return usuarisBaixa;  
    }

    /**
     * Metode que retorna els usuarisBaixa entrenadors (GET)
     * @return els usuarisBaixa que son entrenador true
     */
    @GetMapping("/getUsuariBaixaEntrenador")
    public  List<UsuariBaixa> cercarUsuarisBaixaEntrenadors(){
        List<UsuariBaixa> usuarisBaixa = usuariBaixaService.cercarUsuarisBaixaEntrenadors();
        return usuarisBaixa;  
    }
    
    /**
     * Metode que crea l'usuariBaixa (POST)
     * @param usuariBaixa que es vol crear a la BBDD
     */
    @RequestMapping(value="/addUsuariBaixa", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearUsuariBaixa(@RequestBody @Valid UsuariBaixa usuariBaixa){
        usuariBaixaService.crearUsuariBaixa(usuariBaixa);
        
          
    }
      
    /**
     * Metode que modifica un usuariBaixa (PUT)
     * @param usuariBaixa que es vol modificar
     * @return usuariBaixa modificat
     */
    @PutMapping("/modifyUsuariBaixa")
    public UsuariBaixa editarUsuariBaixa(@RequestBody UsuariBaixa usuariBaixa) {
        UsuariBaixa usuariBaixaR = usuariBaixaService.editarUsuariBaixa(usuariBaixa);
        
        return usuariBaixaR;
    }

    /**
     * Metode que elimina un usuariBaixa (DELETE)
     * @param usuariBaixa que es vol eliminar
     */
    @DeleteMapping("/deleteUsuariBaixa")
    public void eliminarUsuariBaixa(@RequestBody UsuariBaixa usuariBaixa) {
        
            usuariBaixaService.eliminarUsuariBaixa(usuariBaixa);
    }
    
}
