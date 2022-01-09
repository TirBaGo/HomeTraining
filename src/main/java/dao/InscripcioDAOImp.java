/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import model.Inscripcio;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO inscripcio
 * @author Nerea Gallardo
 * @version 1.1
 * @see InscripcioDAO
 */
@Transactional
@Repository("inscripcioDAOImp")
public class InscripcioDAOImp implements InscripcioDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Metode que crea una inscripcio
     * @param inscripcio que es vol crear
     */
    @Override
    public void crearInscripcio(Inscripcio inscripcio) {
        getSession().save(inscripcio);
    }

    /**
     * Metode que edita una inscripcio
     * @param inscripcio que es vol crear
     * @return inscripcio editada
     */
    @Transactional
    @Override
    public Inscripcio editarInscripcio(Inscripcio inscripcio) {
        getSession().update(inscripcio);
        return inscripcio;
    }

    /**
     * Metode que elimina una inscripcio
     * @param inscripcio que es vol crear
     */
    @Override
    public void eliminarInscripcio(Inscripcio inscripcio) {
        getSession().delete(inscripcio);
    }

    /**
     * Metode que cerca inscripcions per dni
     * @param dni que es vol cercar
     * @return inscripcions amb el dni indicat
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_usuari", dni));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * Metode que cerca una inscripcio per id
     * @param id_inscripcio que es vol cercar
     * @return inscripcio amb l'id indicat
     */
    @Override
    public Inscripcio cercarInscripcioPerId(int id_inscripcio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_inscripcio", id_inscripcio));
        return(Inscripcio) criteria.uniqueResult();
    }

    /**
     * Metode que cerca inscripcions per nom rutina 
     * @param nom_rutina que es vol cercar
     * @return inscripcions amb el nom rutina indicat
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerNomRutina(String nom_rutina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom_rutina", nom_rutina));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * MEtode que cerca inscripcions amb is pagat true
     * @return inscripcions que tinguin pagat en true
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerIspagat() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ispagat", true));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * Metode que cerca inscripcions amb is pagat false
     * @return inscripcions que tinguin pagat en false
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerFalseIspagat() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ispagat", false));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * Metode que cerca inscripcions per data d'alta
     * @param data_alta que es vol cercar
     * @return inscripcions amb la data indicada
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDataAlta(Timestamp data_alta) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("data_alta", data_alta));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * MEtode que cerca inscripcions per data fi
     * @param data_fi que es vol cercar
     * @return Inscripcions amb la data indicada
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDataFi(Timestamp data_fi) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("data_fi", data_fi));
        return (List<Inscripcio>) criteria.list();
    }

    /**
     * Metode que cerca totes les inscripcions
     * @return totes les inscripcions
     */
    @Override
    public List<Inscripcio> cercarTotesLesInscripcions() {
        Criteria criteria = createEntityCriteria();
        return (List<Inscripcio>) criteria.list();
    }
    
    /**
     * Metode que agafa una Session
     * @return la sessio que estem fent servir
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Metode que crea una entitat amb la classe entity que l'indiquem
     * @return Crea la sessio amb la classe indicada
     */
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Inscripcio.class);
    }
    
}
