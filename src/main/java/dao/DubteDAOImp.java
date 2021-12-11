/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Dubte;
import model.Queixes;
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
@Repository("dubteDAOImp")
public class DubteDAOImp implements DubteDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearDubte(Dubte dubte) {
        getSession().save(dubte);
    }

    @Override
    public Dubte editarDubte(Dubte dubte) {
        getSession().update(dubte);
        return dubte;
    }

    @Override
    public void eliminarDubte(Dubte dubte) {
        getSession().delete(dubte);

    }

    @Override
    public Dubte cercarDubtePerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Dubte) criteria.uniqueResult();
    }

    @Override
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Dubte>) criteria.list();
    }

    @Override
    public Dubte cercarDubtePerIdDubte(int id_dubte) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_dubte", id_dubte));
        return (Dubte) criteria.uniqueResult();
    }

    @Override
    public List<Dubte> cercarTotsElsDubtes() {
        Criteria criteria = createEntityCriteria();
        return (List<Dubte>) criteria.list();
    }
    
        private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Dubte.class);
    }
    
}
