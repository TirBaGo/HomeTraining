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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/usuari")
public class UsuariController  {

    
   @Autowired
    private UsuariService usuariService;
    public UsuariController() {
    }
 
    public UsuariController(UsuariService usuariService) {
        this.usuariService = usuariService;
    }
    
    @GetMapping("/getUsuaris")
    public List<Usuari> cercarTotsElsUsuaris() {
        return usuariService.cercarTotsElsUsuaris();
    }
    
    @GetMapping("/getUsuariDNI/{dni}")
    public  Usuari cercarUsuariPerDNI(@PathVariable String dni){
        Usuari usuari = usuariService.cercarUsuariPerDNI(dni);
        return usuari;  
    }
    
    @GetMapping("/getUsuariNom/{nom}")
    public  List<Usuari> cercarUsuarisPerNom(@PathVariable String nom){
        List<Usuari> usuaris = usuariService.cercarUsuarisPerNom(nom);
        return usuaris;  
    }
    
    @GetMapping("/getUsuariActiu")
    public  List<Usuari> cercarUsuarisActius(){
        List<Usuari> usuaris = usuariService.cercarUsuarisActius();
        return usuaris;  
    }
    @GetMapping("/getUsuariEntrenador")
    public  List<Usuari> cercarUsuarisEntrenadors(){
        List<Usuari> usuaris = usuariService.cercarUsuarisEntrenadors();
        return usuaris;  
    }
    
     @RequestMapping(value="/addUsuari", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearUsuari(@RequestBody @Valid Usuari usuari){
        usuariService.crearUsuari(usuari);
        
          
    }
      
    @PutMapping("/modifyUsuari")
    public Usuari editarUsuari(@RequestBody Usuari usuari) {
        Usuari usuariR = usuariService.editarUsuari(usuari);
        
        return usuariR;
    }

    @DeleteMapping("/deleteUsuari")
    public void eliminarUsuari(@RequestBody Usuari usuari) {
        
            usuariService.eliminarUsuari(usuari);
        
        
    }
}
