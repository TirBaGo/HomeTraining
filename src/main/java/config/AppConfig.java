package config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

/**
 * Configuració Base de dades, Hibernate i c3p0
 * @author Nerea Gallardo Tirado
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("dao"),
      @ComponentScan("service") })
public class AppConfig {

   @Autowired
   private Environment env;

    /**
     * Metode que agafa totes les propietats per fer la connexió posible i retorna un factoryBean amb aquestes
     * @return factoryBean amb les propietats per a la connexió a la bbdd
     */
    @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      Properties props = new Properties();
      // Setting JDBC properties
      props.put(DRIVER, env.getProperty("jdbc.driverClassName"));
      props.put(URL, env.getProperty("jdbc.url"));
      props.put(USER, env.getProperty("jdbc.username"));
      props.put(PASS, env.getProperty("jdbc.password"));

      // Setting Hibernate properties
      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl"));

      // Setting C3P0 properties
      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
      props.put(C3P0_ACQUIRE_INCREMENT, 
            env.getProperty("hibernate.c3p0.acquire_increment"));
      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setPackagesToScan("model");

      return factoryBean;
   }

    /**
     * Metode per fer la transacció de hibernate
     * @return transactionManager amb l'objecte de la SessionFactory
     */
    @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}