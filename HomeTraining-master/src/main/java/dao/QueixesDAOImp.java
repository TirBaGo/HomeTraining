/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
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
@Repository("queixesDAOImp")
public class QueixesDAOImp implements QueixesDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearQueixa(Queixes queixes) {
        getSession().save(queixes);
    }
    

    @Override
    public Queixes editarQueixa(Queixes queixes) {
        getSession().update(queixes);
        return queixes;
    }

    @Override
    public void eliminarQueixa(Queixes queixes) {
        getSession().delete(queixes);
    }

    @Override
    public Queixes cercarQueixaPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Queixes) criteria.uniqueResult();
    }

    @Override
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari) {
         Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Queixes>) criteria.list();
    }

    @Override
    public Queixes cercarQueixaPerIdQueixes(int id_queixes) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_queixes", id_queixes));
        return (Queixes) criteria.uniqueResult();
    }

    @Override
    public List<Queixes> cercarTotesLesQueixes() {
        Criteria criteria = createEntityCriteria();
        return (List<Queixes>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Queixes.class);
    }
    
}
