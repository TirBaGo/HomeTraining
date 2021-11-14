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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Transactional
@Repository("loginDAOImp")
public class LoginDAOImp implements LoginDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void crearLogin(Login login) {
        getSession().saveOrUpdate(login);
    }

    @Override
    public Login editarLogin(Login login) {
        getSession().update(login);
        return login ;
    }

    @Override
    public void eliminarLogin(Login login) {
        getSession().delete(login);
    }

    @Override
    public Login cercarLoginPerUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Login) criteria.uniqueResult();
    }
    
    @Override
    public Login cercarLoginPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Login) criteria.uniqueResult();
    }

    @Override
    public List<Login> cercarTotsElsLogin() {
        Criteria criteria = createEntityCriteria();
        return (List<Login>) criteria.list();
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Login.class);
    }


    
}
