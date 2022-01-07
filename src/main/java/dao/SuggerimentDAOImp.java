/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Suggeriment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO Suggeriment
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc SuggerimentDAO
 */

@Transactional
@Repository("suggerimentDAOImp")
public class SuggerimentDAOImp implements SuggerimentDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Metode per crear un suggeriment
     * @param suggeriment que es vol crear
     */
    @Override
    public void crearSuggeriment(Suggeriment suggeriment) {
        getSession().save(suggeriment);
    }

    /**
     * Metode per editar un suggeriment
     * @param suggeriment que es vol editar
     * @return suggeriment editat
     */
    @Override
    public Suggeriment editarSuggeriment(Suggeriment suggeriment) {
        getSession().update(suggeriment);
        return suggeriment;
    }

    /**
     * Metode per eliminar un suggeriment
     * @param suggeriment que es vol eliminar
     */
    @Override
    public void eliminarSuggeriment(Suggeriment suggeriment) {
        getSession().delete(suggeriment);
    }

    /**
     * Metode per cercar un suggeriment per nom
     * @param nom que es vol cercar
     * @return suggeriment amb el nom indicat
     */
    @Override
    public Suggeriment cercarSuggerimentPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Suggeriment) criteria.uniqueResult();
    }

    /**
     * Metode que cerca suggeriments per dni de l'usuari creador
     * @param dni_usuari que es vol cercar
     * @return els suggeriments de l'usuari indicat
     */
    @Override
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Suggeriment>) criteria.list();
    }

    /**
     * Metode que cerca suggeriments per id
     * @param id_suggeriment que es vol cercar
     * @return suggeriment amb l'id indicat
     */
    @Override
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_suggeriment", id_suggeriment));
        return (Suggeriment) criteria.uniqueResult();
    }

    /**
     * Metode que retorna tots els suggeriments
     * @return tots els suggeriments
     */
    @Override
    public List<Suggeriment> cercarTotsElsSuggeriments() {
        Criteria criteria = createEntityCriteria();
        return (List<Suggeriment>) criteria.list();
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
        return getSession().createCriteria(Suggeriment.class);
    }
    
}
