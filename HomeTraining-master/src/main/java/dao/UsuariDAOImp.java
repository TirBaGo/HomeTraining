package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Usuari;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Transactional
@Repository("usuariDAOImp")
public class UsuariDAOImp implements UsuariDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void crearUsuari(Usuari usuari) {
        getSession().saveOrUpdate(usuari);
    }

    @Override
    public Usuari editarUsuari(Usuari usuari) {
        getSession().update(usuari);
        return usuari;
    }

    @Override
    public void eliminarUsuari(Usuari usuari) {
        getSession().delete(usuari);
    }

    @Override
    public Usuari cercarUsuariPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Usuari) criteria.uniqueResult();
    }

    @Override
    public List<Usuari> cercarUsuarisPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (List<Usuari>) criteria.list();
    }

    @Override
    public List<Usuari> cercarUsuarisActius() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("active", true));
        return (List<Usuari>) criteria.list();
    }

    @Override
    public List<Usuari> cercarUsuarisEntrenadors() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("isEntrenador", true));
        return (List<Usuari>) criteria.list();
    }

    @Override
    public List<Usuari> cercarTotsElsUsuaris() {
        Criteria criteria = createEntityCriteria();
        return (List<Usuari>) criteria.list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    private Criteria createEntityCriteria(){
        return getSession().createCriteria(Usuari.class);
    }
    
}
