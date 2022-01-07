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
 * Implementació DAO ImatgesRutina
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc ImatgesRutinaDAO
 */
@Transactional
@Repository("imatgesRutinaDAOImp")
public class ImatgesRutinaDAOImp implements ImatgesRutinaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea una imatge_rutina
     * @param imatgesRutina que es vol crear
     */
    @Override
    public void crearImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().saveOrUpdate(imatgesRutina);
    }

    /**
     * Metode que edita una imatge rutina
     * @param imatgesRutina que es vol editar
     * @return Imatge rutina editada
     */
    @Override
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().update(imatgesRutina);
        return imatgesRutina;
    }

    /**
     * Metode que elimina una imatgeRutina
     * @param imatgesRutina que es vol eliminar
     */
    @Override
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina) {
        getSession().delete(imatgesRutina);
    }

    /**
     * Metode que crca totes les imatges rutina
     * @return totes les imatges rutina
     */
    @Override
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        Criteria criteria = createEntityCriteria();
        return (List<ImatgesRutina>) criteria.list();
    }

    /**
     * Metode que cerca per l'id de la imatge
     * @param id_imtage que es vol cercar
     * @return la imatge rutina que coincideix amb l'id
     */
    @Override
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_imatge", id_imtage));
        return (ImatgesRutina) criteria.uniqueResult();
    }

    /**
     * Metode que cerca per l'id d'una rutina
     * @param id_rutina que es vol cercar les seves imatges
     * @return les imatges rutina assocciades amb l'id de rutina indicat
     */
    @Override
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina) {
        Criteria criteria =  createEntityCriteria();
        criteria.add(Restrictions.eq("id_rutina", id_rutina));
        return (List<ImatgesRutina>) criteria.list();
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
        return getSession().createCriteria(ImatgesRutina.class);
    }
    
}
