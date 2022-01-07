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
 * Implementació DAO accessori
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc AccessoriDAO
 */
@Transactional
@Repository("accessoriDAOImp")
public class AccessoriDAOImp implements AccessoriDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode per crear l'accessori
     * @param accessori que es vol crear
     */
    @Override
    public void crearAccessori(Accessori accessori) {
        getSession().saveOrUpdate(accessori);
    }

    /**
     *  Metode per editat l'accessori 
     * @param accessori que es vol modificar
     * @return accessori modificat
     */
    @Override
    public Accessori editarAccessori(Accessori accessori) {
        getSession().update(accessori);
        return accessori;
    }

    /**
     * Metode que elimina l'accessori
     * @param accessori que es vol eliminar
     */
    @Override
    public void eliminarAccessori(Accessori accessori) {
        getSession().delete(accessori);
    }

    /**
     * Metode per cercar accessoris pel seu nom 
     * @param nom de l'accessori que es vol cercar
     * @return l'accessori amb el nom indicar per parametre
     */
    @Override
    public Accessori cercarAccessoriPerNom(String nom) {
       Criteria criteria = createEntityCriteria();
       criteria.add(Restrictions.eq("nom", nom));
       return (Accessori) criteria.uniqueResult();
       
    }

    /**
     * Metode per cercar tots els accessoris
     * @return tots els acccessoris de la base de dades
     */
    @Override
    public List<Accessori> cercarTotsElsAccessoris() {
        Criteria criteria = createEntityCriteria();
        return (List<Accessori>) criteria.list();
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
        return getSession().createCriteria(Accessori.class);
    }
}
