package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configuració web que agafa el paquet controller
 * @author Nerea Gallardo Tirado
 * @version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

}
