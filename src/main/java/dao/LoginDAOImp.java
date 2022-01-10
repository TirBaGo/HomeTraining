/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Login;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO Login
 * @author Nerea Gallardo
 * @version 1.0
 * @see LoginDAO
 */
@Transactional
@Repository("loginDAOImp")
public class LoginDAOImp implements LoginDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Metode que crea el login indicat
     * @param login que es vol crear
     */
    @Override
    public void crearLogin(Login login) {
        getSession().saveOrUpdate(login);
    }

    /**
     * Metode que edita un login
     * @param login que es vol editar
     * @return login editat
     */
    @Override
    public Login editarLogin(Login login) {
        getSession().update(login);
        return login ;
    }

    /**
     * Metode per eliminar un login
     * @param login que es vol eliminar
     */
    @Override
    public void eliminarLogin(Login login) {
        getSession().delete(login);
    }

    /**
     * Metode per cercar un login pel seu username
     * @param username que es vol cercar
     * @return el login amb l'usernam indicat
     */
    @Override
    public Login cercarLoginPerUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Login) criteria.uniqueResult();
    }
    
    /**
     * Metode que cerca pel dni de l'usuari
     * @param dni de l'usuari que es vol cercar
     * @return del login amb el dni indicat
     */
    @Override
    public Login cercarLoginPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Login) criteria.uniqueResult();
    }

    /**
     * Metode que cerca tots els login
     * @return tots els login
     */
    @Override
    public List<Login> cercarTotsElsLogin() {
        Criteria criteria = createEntityCriteria();
        return (List<Login>) criteria.list();
    }
    
    /**
     * Metode que agafa una Session
     * @return la sessio que estem fent servir
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Metode que crea una entitat amb la classe entity que l'indiquem
     * @return Crea la sessio amb la classe indicada
     */
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Login.class);
    }


    
}
