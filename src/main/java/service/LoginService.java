/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Login;

/**
 * Service login
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface LoginService {
    
    /**
     * Crear login
     * @param login que es vol crear 
     */
    public void crearLogin(Login login);

    /**
     * EDitar login   
     * @param login que es vol editar
     * @return login editat
     */
    public Login editarLogin(Login login);

    /**
     * Eliminar login
     * @param login que es vol eliminar
     */
    public void eliminarLogin(Login login);

    /**
     * Cercar login per username
     * @param username que es vol cercar
     * @return login amb l'username que es vol cercar
     */
    public Login cercarLoginPerUsername(String username);

    /**
     * Metode que cerca el login per el dni 
     * @param dni que es vol cercar
     * @return el login amb el dni indicat
     */
    public Login cercarLoginPerDNI(String dni);

    /**
     * Cercar tots els logins
     * @return tots els logins
     */
    public List<Login> cercarTotsElsLogin();
}
