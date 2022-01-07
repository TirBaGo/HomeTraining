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
 * Implementació DAO Modalitat
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc ModalitatDAO
 */
@Transactional
@Repository("modalitatDAOImp")
public class ModalitatDAOImp implements ModalitatDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea una modalitat
     * @param modalitat que es vol crear
     */
    @Override
    public void crearModalitat(Modalitat modalitat) {
        getSession().saveOrUpdate(modalitat);
    }

    /**
     * Metode que edita una modalitat
     * @param modalitat que es vol editar
     * @return modalitat editada
     */
    @Override
    public Modalitat editarModalitat(Modalitat modalitat) {
        getSession().update(modalitat);
        return modalitat;
    }

    /**
     * Metode que elimina una modalitat
     * @param modalitat que es vol eliminar
     */
    @Override
    public void eliminarModalitat(Modalitat modalitat) {
        getSession().delete(modalitat);
    }

    /**
     * Metode que cerca la modalitat per nom
     * @param nom de la modalitat que es vol cercar
     * @return modalitat amb el nom indicat
     */
    @Override
    public Modalitat cercarModalitatPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Modalitat) criteria.uniqueResult();
    }

    /**
     * Metode que crca totes les modalitats
     * @return totes ls modalitats 
     */
    @Override
    public List<Modalitat> cercarTotesLesModalitats() {
        Criteria criteria = createEntityCriteria();
        return (List<Modalitat>) criteria.list();
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
        return getSession().createCriteria(Modalitat.class);
    }
    
}
