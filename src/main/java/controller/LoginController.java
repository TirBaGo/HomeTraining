/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import model.Login;
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
import service.LoginService;

/**
 * Controller de Login
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    /**
     * Metode constructor per defecte
     */
    public LoginController() {
    }
 
    /**
     * Metode que agafa el Service de Login 
     * @param loginService objecte de login service
     */
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    /**
     * MEtode que retorna tots els logins (GET)
     * @return tots els logins de la BBDD
     */
    @GetMapping("/getLogin")
    public List<Login> cercarTotsElsLogin() {
        return loginService.cercarTotsElsLogin();
    }
    
    /**
     * Metode que retorna el login per els seu username (GET)
     * @param username que es vol que ens retorni
     * @return el login amb l'username pasat per parametre
     */
    @GetMapping("/getLoginUsername/{username}")
    public Login cercarLoginPerUsername(@PathVariable String username) {
        Login login = loginService.cercarLoginPerUsername(username);
        return login;
    }
    
    /**
     * Metode que retorna el login per dni (GET)
     * @param dni de l'usuari assocciat amb el login
     * @return el login que coincideix amb el dni passat per parametre
     */
    @GetMapping("/getLoginDNI/{dni}")
    public Login cercarLoginPerDNI(@PathVariable String dni) {
        Login login = loginService.cercarLoginPerDNI(dni);
        return login;
    }
    
    /**
     * Metode que crea un login nou (POST)
     * @param login que es vol introduir en la BBDD
     */
    @RequestMapping(value="/addLogin", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void  crearLogin(@RequestBody @Valid Login login){
        loginService.crearLogin(login);
   
    }
    
    /**
     * Metode que modifica un login existent (PUT)
     * @param login que es vol modificar
     * @return login modificat
     */
    @PutMapping("/modifyLogin")
    public Login editarLogin(@RequestBody Login login) {
        loginService.editarLogin(login);
        return login;
    }

    /**
     * Metode que elimina el login indicat (DELETE)
     * @param login que es vol eliminar
     */
    @DeleteMapping("/deleteLogin")
    public void eliminarLogin(@RequestBody Login login) {
        loginService.eliminarLogin(login);
    }
    
}
