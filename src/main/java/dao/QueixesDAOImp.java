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
 * Implementació DAO Queixes
 * @author Nerea Gallardo
 * @version 1.0
 * @see QueixesDAO
 */

@Transactional
@Repository("queixesDAOImp")
public class QueixesDAOImp implements QueixesDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea queixes
     * @param queixes que es vol crear
     */
    @Override
    public void crearQueixa(Queixes queixes) {
        getSession().save(queixes);
    }
    
    /**
     * Metode que edita queixes
     * @param queixes que es vol editar
     * @return queixa editada
     */
    @Override
    public Queixes editarQueixa(Queixes queixes) {
        getSession().update(queixes);
        return queixes;
    }

    /**
     * Metode que elimina queixes
     * @param queixes que es vol eliminar
     */
    @Override
    public void eliminarQueixa(Queixes queixes) {
        getSession().delete(queixes);
    }

    /**
     * Metode que cerca queixes pel seu nom
     * @param nom de la queixa que es vol cercar
     * @return queixa amb el nom indicat per parametre
     */
    @Override
    public Queixes cercarQueixaPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Queixes) criteria.uniqueResult();
    }

    /**
     * Metode que cerca queixes pel dni de l'usuari que la va crear
     * @param dni_usuari del que es vol cercar les seves queixes
     * @return Queixes amb el dni assocciat pasat per parametre
     */
    @Override
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari) {
         Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni_usuari));
        return (List<Queixes>) criteria.list();
    }

    /**
     * Metode que cerca per l'id de la quixa
     * @param id_queixes ide que es vol cercar
     * @return queixa amb l'id indicat per parametre
     */
    @Override
    public Queixes cercarQueixaPerIdQueixes(int id_queixes) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_queixes", id_queixes));
        return (Queixes) criteria.uniqueResult();
    }

    /**
     * Metode que cerca totes les queixes
     * @return totes les queixes
     */
    @Override
    public List<Queixes> cercarTotesLesQueixes() {
        Criteria criteria = createEntityCriteria();
        return (List<Queixes>) criteria.list();
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
        return getSession().createCriteria(Queixes.class);
    }
    
}
