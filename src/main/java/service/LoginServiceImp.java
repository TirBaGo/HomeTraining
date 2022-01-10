/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LoginDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de login Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see LoginService
 */
@Service
@Transactional
public class LoginServiceImp implements LoginService{
    @Autowired
    private LoginDAO loginDAO;

    /**
     * Metode que crea el login 
     * @param login que es vol crear
     */
    @Transactional
    @Override
    public void crearLogin(Login login) {
        loginDAO.crearLogin(login);
    }

    /**
     * Metode que edita el login
     * @param login que es vol editar
     * @return login editat
     */
    @Transactional
    @Override
    public Login editarLogin(Login login) {
        return loginDAO.editarLogin(login);
    }

    /**
     * MEtode que elimina el login
     * @param login que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarLogin(Login login) {
        loginDAO.eliminarLogin(login);
    }

    /**
     * MEtode que cerca el login per l'username 
     * @param username que es vol cercar
     * @return login amb l'username indicat
     */
    @Override
    public Login cercarLoginPerUsername(String username) {
        return loginDAO.cercarLoginPerUsername(username);
    }

    /**
     * Metode que cerca el login pel dni
     * @param dni que es vol cercar
     * @return login amb el dni indicat
     */
    @Override
    public Login cercarLoginPerDNI(String dni) {
        return loginDAO.cercarLoginPerDNI(dni);
    }

    /**
     * Metode que cerca tots els logins
     * @return tots els logins
     */
    @Override
    public List<Login> cercarTotsElsLogin() {
        return loginDAO.cercarTotsElsLogin();
    }
    
}
