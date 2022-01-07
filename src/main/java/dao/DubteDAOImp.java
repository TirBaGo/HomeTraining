/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Dubte;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO Dubte
 * @author Nerea Gallardo
 * @version 1.0
 * @see DubteDAO
 */

@Transactional
@Repository("dubteDAOImp")
public class DubteDAOImp implements DubteDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea un dubte 
     * @param dubte que es vol crear
     */
    @Override
    public void crearDubte(Dubte dubte) {
        getSession().save(dubte);
    }

    /**
     * Metode que edita un dubte
     * @param dubte que es vol editar
     * @return dubte editat
     */
    @Override
    public Dubte editarDubte(Dubte dubte) {
        getSession().update(dubte);
        return dubte;
    }

    /**
     * Metode que elimina un dubte
     * @param dubte que es vol eliminar
     */
    @Override
    public void eliminarDubte(Dubte dubte) {
        getSession().delete(dubte);

    }

    /**
     * Metode que cerca un dubte pel seu nom
     * @param nom del dubte que es vol cercar
     * @return dubte amb el nom indicat per parametre
     */
    @Override
    public Dubte cercarDubtePerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Dubte) criteria.uniqueResult();
    }

    /**
     * Metode que cerca per el dni de l'usuari creador
     * @param dni_usuari de l'usuari que va crear els dubtes
     * @return els dubtes amb el dni indicat per parametre
     */
    @Override
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Dubte>) criteria.list();
    }

    /**
     * Metode que cerca dubtes pel seu id
     * @param id_dubte del dubte que es vol cercar
     * @return dubte amb l'id pasat per parametre
     */
    @Override
    public Dubte cercarDubtePerIdDubte(int id_dubte) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_dubte", id_dubte));
        return (Dubte) criteria.uniqueResult();
    }

    /**
     * Metode que cerca tots els dubtes
     * @return tots els dubtes
     */
    @Override
    public List<Dubte> cercarTotsElsDubtes() {
        Criteria criteria = createEntityCriteria();
        return (List<Dubte>) criteria.list();
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
        return getSession().createCriteria(Dubte.class);
    }
    
}
