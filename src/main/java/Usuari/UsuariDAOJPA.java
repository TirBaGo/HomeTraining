/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuari;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Stateless
public class UsuariDAOJPA implements UsuariDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void crearUsuari(Usuari usuari) {
        entityManager.persist(usuari);
    }

    @Override
    public Usuari editarUsuari(Usuari usuari) {
        return entityManager.merge(usuari);
    }

    @Override
    public void eliminarUsuari(Usuari usuari) {
        usuari = entityManager.merge(usuari);
        entityManager.remove(usuari); 
    }

    @Override
    public Usuari cercarUsuariPerDNI(String DNI) {
        try {
            return (Usuari) entityManager.createQuery("select object(u) from usuari u " +
            "where u.DNI = :DNI")
            .setParameter("DNI", DNI)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuari> cercarUsuarisPerNom(String nom) {
        try {
            return (List<Usuari>) entityManager.createQuery("select object(u) from usuari u " +
            "where u.nom= :nom")
            .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuari> cercarUsuarisActius() {
        try {
            return (List<Usuari>) entityManager.createQuery("select object(u) from usuari u " +
            "where u.active= true")
            .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuari> cercarUsuarisEntrenadors() {
        try {
            return (List<Usuari>) entityManager.createQuery("select object(u) from usuari u " +
            "where u.isEntrenador= true")
            .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuari> cercarTotsElsUsuaris() {
        try {
            return (List<Usuari>) entityManager.createQuery("select object(u) from usuari u ")
            .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
