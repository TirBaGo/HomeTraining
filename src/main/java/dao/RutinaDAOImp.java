/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Rutina;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO Rutina
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc RutinaDAO
 */
@Transactional
@Repository("rutinaDAOImp")
public class RutinaDAOImp implements RutinaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode per crear una rutina
     * @param rutina que es vol crear
     */
    @Override
    public void crearRutina(Rutina rutina) {
        getSession().save(rutina);
    }

    /**
     * MEtode per editar una rutina
     * @param rutina que es vol editar
     * @return rutina editada
     */
    @Override
    public Rutina editarRutina(Rutina rutina) {
        getSession().update(rutina);
        return rutina;
    }

    /**
     * Metode per eliminar una rutina
     * @param rutina que es vol eliminar
     */
    @Override
    public void eliminarRutina(Rutina rutina) {
        getSession().delete(rutina);
    }

    /**
     * Metode per cercar rutines per nom
     * @param nom que es vol cercar
     * @return la rutina amb el nom indicat
     */
    @Override
    public Rutina cercarRutinaPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Rutina) criteria.uniqueResult() ;
    }

    /**
     * Metode per cercar rutina per el dni de l'entrenador que la va crear
     * @param dni_entrenador que es vol cercar les seves rutines
     * @return rutines de l'entrenador amb el dni indicat
     */
    @Override
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_entrenador", dni_entrenador));
        return (List<Rutina>) criteria.list();
    }

    /**
     * Metode que cerca rutines per la seva modalitat
     * @param nom_modalitat que es vol cercar
     * @return les rutines amb la modalitat indicada
     */
    @Override
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat) {
        Criteria criteria =  createEntityCriteria();
        criteria.add(Restrictions.eq("nom_modalitat", nom_modalitat));
        return (List<Rutina>) criteria.list();
    }

    /**
     * Metode per cercar rutines per el seu accessori
     * @param nom_accessori que es vol cercar
     * @return les rutines amb l'accessori indicat
     */
    @Override
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom_accessori", nom_accessori));
        return (List<Rutina>) criteria.list();
    }

    /**
     * Metode que cerca les rutines actives
     * @return les rutines amb acitv true
     */
    @Override
    public List<Rutina> cercarRutinaActiva() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("active", true));
        return (List<Rutina>)criteria.list();
    }

    /**
     * MEtode que cerca totes les rutines
     * @return totes les rutines
     */
    @Override
    public List<Rutina> cercarTotesLesRutines() {
        Criteria criteria = createEntityCriteria();
        return (List<Rutina>) criteria.list();
    }

    /**
     * Metode que cerca les rutines per nivell
     * @param nivell que es vol cercar
     * @return les rutines amb el nivell indicat
     */
    @Override
    public List<Rutina> cercarRutinaNivell(int nivell) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nivell", nivell));
        return (List<Rutina>) criteria.list();
    }

    /**
     * Meotde que cerca rutines per duració
     * @param duracio que es vol cercar 
     * @return les rtuines amb la duració indicada
     */
    @Override
    public List<Rutina> cercarRutinaDuracio(int duracio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("duracio", duracio));
        return (List<Rutina>) criteria.list();
    }

    /**
     * Metode que cerca rutines per preu
     * @param preu que es vol cercar
     * @return les rutines amb le preu indicat
     */
    @Override
    public List<Rutina> cercarRutinaPreu(double preu) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("preu", preu));
        return (List<Rutina>) criteria.list();
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
        return getSession().createCriteria(Rutina.class);
    }
}
