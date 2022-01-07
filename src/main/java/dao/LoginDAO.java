/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Login;

/**
 * DAO Login
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface LoginDAO {

    /**
     * Crear login
     * @param login que es vol crear
     */
    public void crearLogin(Login login);

    /**
     * Editar login
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
     * Cercar per username
     * @param username que es vol cercar
     * @return usuari amb l'username introduit
     */
    public Login cercarLoginPerUsername(String username);

    /**
     * Cercar per dni usuari
     * @param dni que es vol cercar
     * @return l'usuari amb el dni indicat
     */
    public Login cercarLoginPerDNI(String dni);

    /**
     * Cercar tots els login
     * @return tots els login
     */
    public List<Login> cercarTotsElsLogin();
    
}
