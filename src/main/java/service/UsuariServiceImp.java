package service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuariDAO;
import model.Usuari;

/**
 * Implementació de usuari Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see UsuariService
 */
@Service
@Transactional
public class UsuariServiceImp implements UsuariService{
    
    @Autowired
    private UsuariDAO usuariDAO;

    /**
     * Metode que crea usuaris
     * @param usuari que es vol crear
     */
    @Transactional
    @Override
    public void crearUsuari(Usuari usuari) {
        usuariDAO.crearUsuari(usuari);
    }

    /**
     * MEtode que edita usuaris
     * @param usuari que es vol editar
     * @return usuari editat
     */
    @Transactional
    @Override
    public Usuari editarUsuari( Usuari usuari) {
        return usuariDAO.editarUsuari(usuari);
    }

    /**
     * Metode que elimina usuari 
     * @param usuari que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarUsuari(Usuari usuari) {
        usuariDAO.eliminarUsuari(usuari);
    }

    /**
     * Metode que cerca usuaris per dni
     * @param dni que es vol cercar
     * @return l'usuari amb el dni indicat
     */
    @Override
    public Usuari cercarUsuariPerDNI(String dni) {
        return usuariDAO.cercarUsuariPerDNI(dni);
    }

    /**
     * Metode que cerca usuaris per nom 
     * @param nom que es vol cercar
     * @return usuaris amb el nom indicat
     */
    @Override
    public List<Usuari> cercarUsuarisPerNom(String nom) {
        return usuariDAO.cercarUsuarisPerNom(nom);
    }

    /**
     * Metode que cerca usuaris actius
     * @return usuaris amb actiu true
     */
    @Override
    public List<Usuari> cercarUsuarisActius() {
        return usuariDAO.cercarUsuarisActius();
    }

    /**
     * Metode que cerca usuaris entrenadors 
     * @return usuaris amb entrenador en true
     */
    @Override
    public List<Usuari> cercarUsuarisEntrenadors() {
        return usuariDAO.cercarUsuarisEntrenadors();
    }

    /**
     * MEtode que cerca tots els usuaris
     * @return tots els usuaris
     */
    @Override
    public List<Usuari> cercarTotsElsUsuaris() {
        return usuariDAO.cercarTotsElsUsuaris();
    }



  
}

