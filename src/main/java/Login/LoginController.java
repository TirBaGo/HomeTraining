/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Usuari.Usuari;
import Usuari.UsuariDAO;

/**
 *
 * @author ngall
 */
public class LoginController {
        private LoginDAO loginDAO;
    
    public LoginController(LoginDAO loginDAO){
        this.loginDAO = loginDAO;
    }
    public Login getUsername(String username){
        return loginDAO.cercarLoginPerUsername(username);
    }
}
