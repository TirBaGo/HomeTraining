/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuari;

import Config.HibernatePostgreSQLConfiguration;
import Usuari.UsuariDAO;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Timestamp;
import java.util.Date;
import Usuari.Usuari;
import java.util.List;
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
public class UsuariDAOTest {
     @Autowired
    private UsuariDAO usuariDAO;
    private Usuari usuari = new Usuari();

     @Test 
    public void AguardarUsuari() {

        usuari.setDNI("47919553L");
        usuari.setNom("Nerea");
        usuari.setCognom1("Gallardo");
        usuari.setCognom2("Tirado");
        usuari.setEmail("ngallardotirao@gmail.com");
        usuari.setTelefon(690834839);
        usuari.setAdreca("Carrer de prova");
        usuari.setProvincia("Test");
        usuari.setPoblacio("Test");
        usuari.setIsEntrenador(false);
        usuari.setData_alta(new Timestamp(new Date().getTime()));
        usuari.setActive(true);
        usuariDAO.crearUsuari(usuari);
        assertNotNull(usuari.getDNI());

        Usuari userFromDb = usuariDAO.cercarUsuariPerDNI("47919553L");
        assertEquals(usuari.getDNI(), userFromDb.getDNI());
    }
    
    

    
    @Test
    public void BcercarUsuariNom() {
        List<Usuari> userFromDb = usuariDAO.cercarUsuarisPerNom("Nerea");
        for( int i = 0; i>= userFromDb.size();i++){
            assertEquals(usuari.getNom(), userFromDb.get(0).getNom());
        }
        
    }
    
    @Test
    public void CModificarusuari() {
        usuari.setDNI("47919553L");
        usuari.setNom("Nerea");
        usuari.setCognom1("Gallardo");
        usuari.setCognom2("Tirado");
        usuari.setEmail("ngallardotirao@gmail.com");
        usuari.setTelefon(690834839);
        usuari.setAdreca("Carrer de prova");
        usuari.setProvincia("TestPRovaChange");
        usuari.setPoblacio("Test");
        usuari.setIsEntrenador(false);
        usuari.setData_alta(new Timestamp(new Date().getTime()));
        usuari.setActive(false);
        usuariDAO.editarUsuari(usuari);
        
        Usuari userFromDb = usuariDAO.cercarUsuariPerDNI("47919553L");
        assertEquals(usuari.getDNI(), userFromDb.getDNI());
        
    }
    
    @Test
    public void DeliminarUsuari() {
        usuari.setDNI("47919553L");
       usuariDAO.eliminarUsuari(usuari);
    }
   
    
}
    

