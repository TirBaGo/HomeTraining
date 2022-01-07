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
 * Implementació DAO Usuari
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc UsuariDAO
 */
@Transactional
@Repository("usuariDAOImp")
public class UsuariDAOImp implements UsuariDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea un usuari
     * @param usuari que es vol crear
     */
    @Override
    public void crearUsuari(Usuari usuari) {
        getSession().saveOrUpdate(usuari);
    }

    /**
     * Metode que edita un usuari
     * @param usuari que es vol editar
     * @return usuari editat 
     */
    @Override
    public Usuari editarUsuari(Usuari usuari) {
        getSession().update(usuari);
        return usuari;
    }

    /**
     * Metode per eliminar un usuari
     * @param usuari que es vol eliminar
     */
    @Override
    public void eliminarUsuari(Usuari usuari) {
        getSession().delete(usuari);
    }

    /**
     * Metode per cercar un usuari per el seu dni 
     * @param dni que es vol cercar
     * @return usuari amb el dni indicat
     */
    @Override
    public Usuari cercarUsuariPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Usuari) criteria.uniqueResult();
    }

    /**
     * Metode que cerca usuaris per el seu nom
     * @param nom que es vol cercar
     * @return usuaris amb el nom indicat
     */
    @Override
    public List<Usuari> cercarUsuarisPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (List<Usuari>) criteria.list();
    }

    /**
     * Metode que cerca usuaris actius
     * @return usuaris active true
     */
    @Override
    public List<Usuari> cercarUsuarisActius() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("active", true));
        return (List<Usuari>) criteria.list();
    }

    /**
     * MEtode que cerca usuaris entrenadors
     * @return usuaris entrenadors true
     */
    @Override
    public List<Usuari> cercarUsuarisEntrenadors() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("isEntrenador", true));
        return (List<Usuari>) criteria.list();
    }

    /**
     * Metode que cerca tots els usuaris
     * @return tots els usuaris
     */
    @Override
    public List<Usuari> cercarTotsElsUsuaris() {
        Criteria criteria = createEntityCriteria();
        return (List<Usuari>) criteria.list();
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
        return getSession().createCriteria(Usuari.class);
    }
    
}
