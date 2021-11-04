/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuari;


import Other.config.SpringTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import Usuari.Usuari;
import Usuari.UsuariController;
import Usuari.UsuariDAO;
import static org.junit.Assert.assertEquals;
 

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Nerea Gallardo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class})
public class UsuariControllerTest {
    @Autowired
    private UsuariDAO usuariDAO;

    @Autowired
    private UsuariController usuariController;

    @Test
    public void cercarUsuariPerDNI() {
        String DNI = "test";
        Usuari usuari = new Usuari();
        usuari.setDNI(DNI);

        when(usuariDAO.cercarUsuariPerDNI(DNI)).thenReturn(usuari);

        Usuari usuariResultat = usuariController.getUsuari(DNI);
        assertEquals(DNI, usuariResultat.getDNI());
        verify(usuariDAO, times(1)).cercarUsuariPerDNI(DNI);
    }
    
}
