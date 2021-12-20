/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Accessori;
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
@Repository("accessoriDAOImp")
public class AccessoriDAOImp implements AccessoriDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearAccessori(Accessori accessori) {
        getSession().saveOrUpdate(accessori);
    }

    @Override
    public Accessori editarAccessori(Accessori accessori) {
        getSession().update(accessori);
        return accessori;
    }

    @Override
    public void eliminarAccessori(Accessori accessori) {
        getSession().delete(accessori);
    }

    @Override
    public Accessori cercarAccessoriPerNom(String nom) {
       Criteria criteria = createEntityCriteria();
       criteria.add(Restrictions.eq("nom", nom));
       return (Accessori) criteria.uniqueResult();
       
    }

    @Override
    public List<Accessori> cercarTotsElsAccessoris() {
        Criteria criteria = createEntityCriteria();
        return (List<Accessori>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Accessori.class);
    }
}
