/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Login;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface LoginService {
    
    public void crearLogin(Login login);
    public Login editarLogin(Login login);
    public void eliminarLogin(Login login);
    public Login cercarLoginPerUsername(String username);
    public Login cercarLoginPerDNI(String dni);
    public List<Login> cercarTotsElsLogin();
}
