/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.Rutina;
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
@Repository("rutinaDAOImp")
public class RutinaDAOImp implements RutinaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearRutina(Rutina rutina) {
        getSession().save(rutina);
    }

    @Override
    public Rutina editarRutina(Rutina rutina) {
        getSession().update(rutina);
        return rutina;
    }

    @Override
    public void eliminarRutina(Rutina rutina) {
        getSession().delete(rutina);
    }

    @Override
    public Rutina cercarRutinaPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (Rutina) criteria.uniqueResult() ;
    }

    @Override
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni_entrenador", dni_entrenador));
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat) {
        Criteria criteria =  createEntityCriteria();
        criteria.add(Restrictions.eq("nom_modalitat", nom_modalitat));
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom_accessori", nom_accessori));
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaActiva() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("active", true));
        return (List<Rutina>)criteria.list();
    }

    @Override
    public List<Rutina> cercarTotesLesRutines() {
        Criteria criteria = createEntityCriteria();
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaNivell(int nivell) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nivell", nivell));
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaDuracio(int duracio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("duracio", duracio));
        return (List<Rutina>) criteria.list();
    }

    @Override
    public List<Rutina> cercarRutinaPreu(double preu) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("preu", preu));
        return (List<Rutina>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Rutina.class);
    }
}
