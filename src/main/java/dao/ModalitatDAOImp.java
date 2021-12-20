/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Modalitat;
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
@Repository("modalitatDAOImp")
public class ModalitatDAOImp implements ModalitatDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearModalitat(Modalitat modalitat) {
        getSession().saveOrUpdate(modalitat);
    }

    @Override
    public Modalitat editarModalitat(Modalitat modalitat) {
        getSession().update(modalitat);
        return modalitat;
    }

    @Override
    public void eliminarModalitat(Modalitat modalitat) {
        getSession().delete(modalitat);
    }

    @Override
    public Modalitat cercarModalitatPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Modalitat) criteria.uniqueResult();
    }

    @Override
    public List<Modalitat> cercarTotesLesModalitats() {
        Criteria criteria = createEntityCriteria();
        return (List<Modalitat>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Modalitat.class);
    }
    
}
