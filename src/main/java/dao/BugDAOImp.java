/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Bug;
import org.apache.maven.artifact.versioning.Restriction;
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
@Repository("bugDAOImp")
public class BugDAOImp implements BugDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearBug(Bug bug) {
        getSession().save(bug);
    }

    @Override
    public Bug editarBug(Bug bug) {
        getSession().update(bug);
        return bug;
    }

    @Override
    public void eliminarBug(Bug bug) {
        getSession().delete(bug);
    }

    @Override
    public Bug cercarBugPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Bug) criteria.uniqueResult();
    }

    @Override
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Bug>) criteria.list();
    }

    @Override
    public Bug cercarBugPerIdBug(int id_bug) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_bug", id_bug));
        return (Bug) criteria.uniqueResult();
    }

    @Override
    public List<Bug> cercarTotsElsBugs() {
        Criteria criteria = createEntityCriteria();
        return (List<Bug>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Bug.class);
    }
    
}
