/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Dubte;
import model.Suggeriment;
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
@Repository("suggerimentDAOImp")
public class SuggerimentDAOImp implements SuggerimentDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    


    @Override
    public void crearSuggeriment(Suggeriment suggeriment) {
        getSession().save(suggeriment);
    }

    @Override
    public Suggeriment editarSuggeriment(Suggeriment suggeriment) {
        getSession().update(suggeriment);
        return suggeriment;
    }

    @Override
    public void eliminarSuggeriment(Suggeriment suggeriment) {
        getSession().delete(suggeriment);
    }

    @Override
    public Suggeriment cercarSuggerimentPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Suggeriment) criteria.uniqueResult();
    }

    @Override
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Suggeriment>) criteria.list();
    }

    @Override
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_suggeriment", id_suggeriment));
        return (Suggeriment) criteria.uniqueResult();
    }

    @Override
    public List<Suggeriment> cercarTotsElsSuggeriments() {
        Criteria criteria = createEntityCriteria();
        return (List<Suggeriment>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Suggeriment.class);
    }
    
}
