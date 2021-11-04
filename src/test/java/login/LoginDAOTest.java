/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Config.HibernatePostgreSQLConfiguration;
import Login.Login;
import Login.LoginDAO;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {HibernatePostgreSQLConfiguration.class})
public class LoginDAOTest {
     @Autowired
    private LoginDAO loginDAO;
    private Login login = new Login();

     @Test 
    public void AguardarLogin() {

        login.setUsername("nereiya");
        login.setPassword("nereiya");
        login.setDni("47919553L");
        loginDAO.crearLogin(login);

        Login loginFromDb = loginDAO.cercarLoginPerUsername("nereiya");
        assertEquals(login.getUsername(), loginFromDb.getUsername());
    }
    

    
    @Test
    public void BModificarLogin() {
        
        login.setUsername("nereiya");
        login.setPassword("nereadmin");
        login.setDni("47919553L");
        login = loginDAO.editarLogin(login);

        Login loginFromDb = loginDAO.cercarLoginPerUsername("nereiya");
        assertEquals(login.getUsername(), loginFromDb.getUsername());

    }
    
    /**
    @Test
    public void CeliminarLogin() {
       login.setUsername("nereiya");
       loginDAO.eliminarLogin(login);
    }
   */
    
}
    

