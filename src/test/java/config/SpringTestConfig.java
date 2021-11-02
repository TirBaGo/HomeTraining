/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other.config;


import Usuari.UsuariController;
import Usuari.UsuariDAO;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Configuration
public class SpringTestConfig {
    @Bean
    public UsuariDAO usuariDAO() {
        return Mockito.mock(UsuariDAO.class);
    }

    @Bean
    public UsuariController usuariController(UsuariDAO usuariDAO) {
        return new UsuariController(usuariDAO);
    }
}
