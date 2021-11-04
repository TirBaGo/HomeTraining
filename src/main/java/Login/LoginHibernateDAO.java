/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.transaction.Transactional;
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
@Repository("loginHibernateDAO")
public class LoginHibernateDAO implements LoginDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void crearLogin(Login login) {
        getSession().saveOrUpdate(login);
    }

    @Override
    public Login editarLogin(Login login) {
        return (Login) getSession().merge(login);
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
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Login.class);
    }
    
}
