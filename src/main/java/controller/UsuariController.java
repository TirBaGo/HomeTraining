package controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Usuari;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UsuariService;

/**
 * Controller de Usuari
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/usuari")
public class UsuariController  {

    
   @Autowired
    private UsuariService usuariService;

    /**
     * Metode constructor per defecte
     */
    public UsuariController() {
    }
 
    /**
     * Metode que agafa el Service de usuari
     * @param usuariService objecte amb el UsuariService
     */
    public UsuariController(UsuariService usuariService) {
        this.usuariService = usuariService;
    }
    
    /**
     * Metode que retorna tots els usuaris (GET)
     * @return tots els usuaris de la base de dades
     */
    @GetMapping("/getUsuaris")
    public List<Usuari> cercarTotsElsUsuaris() {
        return usuariService.cercarTotsElsUsuaris();
    }
    
    /**
     * Metode que retorna l'usari pel seu dni (GET)
     * @param dni de l'usuari que es vol cercar 
     * @return l'usuari amb el dni pasat per parametre
     */ 
    @GetMapping("/getUsuariDNI/{dni}")
    public  Usuari cercarUsuariPerDNI(@PathVariable String dni){
        Usuari usuari = usuariService.cercarUsuariPerDNI(dni);
        return usuari;  
    }
    
    /**
     * Metode que retorna l'usuari pel seu nom (GET)
     * @param nom de l'usuari que es vol cercar
     * @return retorna els usuaris amb el nom pasat per parametre
     */
    @GetMapping("/getUsuariNom/{nom}")
    public  List<Usuari> cercarUsuarisPerNom(@PathVariable String nom){
        List<Usuari> usuaris = usuariService.cercarUsuarisPerNom(nom);
        return usuaris;  
    }
    
    /**
     * Metode que retorna els usuari actius (GET)
     * @return retorna els usuaris amb actiu true
     */
    @GetMapping("/getUsuariActiu")
    public  List<Usuari> cercarUsuarisActius(){
        List<Usuari> usuaris = usuariService.cercarUsuarisActius();
        return usuaris;  
    }

    /**
     * Metode que retorna els usuaris entrenadors (GET)
     * @return els usuaris que son entrenador true
     */
    @GetMapping("/getUsuariEntrenador")
    public  List<Usuari> cercarUsuarisEntrenadors(){
        List<Usuari> usuaris = usuariService.cercarUsuarisEntrenadors();
        return usuaris;  
    }
    
    /**
     * Metode que crea l'usuari (POST)
     * @param usuari que es vol crear a la BBDD
     */
    @RequestMapping(value="/addUsuari", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearUsuari(@RequestBody @Valid Usuari usuari){
        usuariService.crearUsuari(usuari);
        
          
    }
      
    /**
     * Metode que modifica un usuari (PUT)
     * @param usuari que es vol modificar
     * @return usuari modificat
     */
    @PutMapping("/modifyUsuari")
    public Usuari editarUsuari(@RequestBody Usuari usuari) {
        Usuari usuariR = usuariService.editarUsuari(usuari);
        
        return usuariR;
    }

    /**
     * Metode que elimina un usuari (DELETE)
     * @param usuari que es vol eliminar
     */
    @DeleteMapping("/deleteUsuari")
    public void eliminarUsuari(@RequestBody Usuari usuari) {
        
            usuariService.eliminarUsuari(usuari);
    }
}
