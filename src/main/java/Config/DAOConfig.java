/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Usuari.UsuariDAO;
import Usuari.UsuariHibernateDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Configuration
public class DAOConfig {
    @Bean
    public UsuariDAO usuariDAO() {
        return new UsuariHibernateDAO();
    }
    
}
