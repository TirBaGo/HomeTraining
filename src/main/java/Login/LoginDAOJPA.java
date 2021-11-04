/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Usuari.Usuari;
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
public class LoginDAOJPA implements LoginDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearLogin(Login login) {
        entityManager.persist(login);
    }

    @Override
    public Login editarLogin(Login login) {
        return entityManager.merge(login);
    }

    @Override
    public void eliminarLogin(Login login) {
        login = entityManager.merge(login);
        entityManager.remove(login); 
    }

    @Override
    public Login cercarLoginPerUsername(String username) {
        try {
            return (Login) entityManager.createQuery("select object(l) from login l " +
            "where l.username = :username")
            .setParameter("username", username)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
