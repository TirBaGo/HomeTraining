/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Bug;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO Bug
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc BugDAO
 */
@Transactional
@Repository("bugDAOImp")
public class BugDAOImp implements BugDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode per crear el bug
     * @param bug que es vol guardar
     */
    @Override
    public void crearBug(Bug bug) {
        getSession().save(bug);
    }

    /**
     * Metode per editar el bug pasat per parametre
     * @param bug que es vol editar
     * @return bug editat
     */
    @Override
    public Bug editarBug(Bug bug) {
        getSession().update(bug);
        return bug;
    }

    /**
     * Metode per eliminar el bug pasat per parametre
     * @param bug que es vole eliminar
     */
    @Override
    public void eliminarBug(Bug bug) {
        getSession().delete(bug);
    }

    /**
     * Metode que cerca per nom
     * @param nom del bug que es vol cercar
     * @return el bug amb el nom del parametre
     */
    @Override
    public Bug cercarBugPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Bug) criteria.uniqueResult();
    }

    /**
     * Metode que cerca per el dni de l'usuari 
     * @param dni_usuari del creador del bug
     * @return tots els bugs que ha crear l'usuari amb el dni indicat per parametre
     */
    @Override
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Bug>) criteria.list();
    }

    /**
     * Metode que cerca el bug pel seu id
     * @param id_bug del bug que es vol cercar
     * @return el bug amb l'id del parametre
     */
    @Override
    public Bug cercarBugPerIdBug(int id_bug) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_bug", id_bug));
        return (Bug) criteria.uniqueResult();
    }

    /**
     * Metode que cerca tots els bugs
     * @return tots els bugs
     */
    @Override
    public List<Bug> cercarTotsElsBugs() {
        Criteria criteria = createEntityCriteria();
        return (List<Bug>) criteria.list();
    }
    
    /**
     * Metode que agafa una Session
     * @return la sessio que estem fent servir
     */
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Metode que crea una entitat amb la classe entity que l'indiquem
     * @return Crea la sessio amb la classe indicada
     */
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Bug.class);
    }
    
}
