/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.transaction.Transactional;
import model.ImatgesRutina;
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
@Repository("imatgesRutinaDAOImp")
public class ImatgesRutinaDAOImp implements ImatgesRutinaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().saveOrUpdate(imatgesRutina);
    }

    @Override
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().update(imatgesRutina);
        return imatgesRutina;
    }

    @Override
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().delete(imatgesRutina);
    }

    @Override
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        Criteria criteria = createEntityCriteria();
        return (List<ImatgesRutina>) criteria.list();
    }

    @Override
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_imatge", id_imtage));
        return (ImatgesRutina) criteria.uniqueResult();
    }

    @Override
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina) {
        Criteria criteria =  createEntityCriteria();
        criteria.add(Restrictions.eq("id_rutina", id_rutina));
        return (List<ImatgesRutina>) criteria.list();
    }
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(ImatgesRutina.class);
    }
    
}
