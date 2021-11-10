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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class LoginServiceImp implements LoginService{
    @Autowired
    private LoginDAO loginDAO;

    @Transactional
    @Override
    public void crearLogin(Login login) {
        loginDAO.crearLogin(login);
    }

    @Transactional
    @Override
    public Login editarLogin(Login login) {
        return loginDAO.editarLogin(login);
    }

    @Transactional
    @Override
    public void eliminarLogin(Login login) {
        loginDAO.eliminarLogin(login);
    }

    @Override
    public Login cercarLoginPerUsername(String username) {
        return loginDAO.cercarLoginPerUsername(username);
    }

    @Override
    public Login cercarLoginPerDNI(String dni) {
        return loginDAO.cercarLoginPerDNI(dni);
    }

    @Override
    public List<Login> cercarTotsElsLogin() {
        return loginDAO.cercarTotsElsLogin();
    }
    
}
