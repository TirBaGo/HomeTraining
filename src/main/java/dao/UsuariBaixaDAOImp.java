/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import model.UsuariBaixa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementació DAO UsuariBaixa
 * @author Nerea Gallardo
 * @version 1.0
 * @see UsuariBaixaDAO
 */
@Transactional
@Repository("usuariBaixaDAOImp")
public class UsuariBaixaDAOImp implements UsuariBaixaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metode que crea un usuariBaixa
     * @param usuariBaixa que es vol crear
     */
    @Override
    public void crearUsuariBaixa(UsuariBaixa usuariBaixa) {
        getSession().save(usuariBaixa);
    }

    /**
     * Metode que edita un usuari
     * @param usuariBaixa que es vol editar
     * @return usuari editat 
     */
    @Override
    public UsuariBaixa editarUsuariBaixa(UsuariBaixa usuariBaixa) {
        getSession().update(usuariBaixa);
        return usuariBaixa;
    }

    /**
     * Metode per eliminar un usuari
     * @param usuariBaixa que es vol eliminar
     */
    @Override
    public void eliminarUsuariBaixa(UsuariBaixa usuariBaixa) {
        getSession().delete(usuariBaixa);
    }

    /**
     * Metode per cercar un usuari per el seu dni 
     * @param dni que es vol cercar
     * @return usuari amb el dni indicat
     */
    @Override
    public UsuariBaixa cercarUsuariBaixaPerDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (UsuariBaixa) criteria.uniqueResult();
    }

    /**
     * Metode que cerca usuaris per el seu nom
     * @param nom que es vol cercar
     * @return usuaris amb el nom indicat
     */
    @Override
    public List<UsuariBaixa> cercarUsuarisBaixaPerNom(String nom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", nom));
        return (List<UsuariBaixa>) criteria.list();
    }

    /**
     * Metode per cercar usuariBaixa per data baixa
     * @param data_baixa que es vol cercar
     * @return usuariBaixa amb la data indicada
     */
    @Override
    public List<UsuariBaixa> cercarUsuariBaixaPerDataBaixa(Timestamp data_baixa){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("data_baixa", data_baixa));
        return (List<UsuariBaixa>) criteria.list();
    }

    /**
     * MEtode que cerca usuaris entrenadors
     * @return usuaris entrenadors true
     */
    @Override
    public List<UsuariBaixa> cercarUsuarisBaixaEntrenadors() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("isEntrenador", true));
        return (List<UsuariBaixa>) criteria.list();
    }

    /**
     * Metode que cerca tots els usuaris
     * @return tots els usuaris
     */
    @Override
    public List<UsuariBaixa> cercarTotsElsUsuarisBaixa() {
        Criteria criteria = createEntityCriteria();
        return (List<UsuariBaixa>) criteria.list();
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
        return getSession().createCriteria(UsuariBaixa.class);
    }
    
    
}
