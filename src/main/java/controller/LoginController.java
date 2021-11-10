/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.LoginService;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    public LoginController() {
    }
 
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @GetMapping("/getLogin")
    public List<Login> cercarTotsElsLogin() {
        return loginService.cercarTotsElsLogin();
    }
    
    @GetMapping("/getLoginUsername/{username}")
    public Login cercarLoginPerUsername(String username) {
        return loginService.cercarLoginPerUsername(username);
    }
    
    @GetMapping("/getLoginDNI/{dni}")
    public Login cercarLoginPerDNI(String dni) {
        return loginService.cercarLoginPerDNI(dni);
    }
    
    @PostMapping("/addLogin")
    public void  crearLogin( Login login){
        loginService.crearLogin(login);
   
    }
    
    @PutMapping("/modifyLogin")
    public Login editarLogin(Login login) {
        loginService.editarLogin(login);
        return login;
    }

    @DeleteMapping("/deleteLogin")
    public void eliminarLogin(Login login) {
        loginService.eliminarLogin(login);
    }
    
}
