package service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuariDAO;
import model.Usuari;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class UsuariServiceImp implements UsuariService{
    
    @Autowired
    private UsuariDAO usuariDAO;

    @Transactional
    @Override
    public void crearUsuari(Usuari usuari) {
        usuariDAO.crearUsuari(usuari);
    }

    @Transactional
    @Override
    public Usuari editarUsuari( Usuari usuari) {
        return usuariDAO.editarUsuari(usuari);
    }

    @Transactional
    @Override
    public void eliminarUsuari(Usuari usuari) {
        usuariDAO.eliminarUsuari(usuari);
    }

    @Override
    public Usuari cercarUsuariPerDNI(String dni) {
        return usuariDAO.cercarUsuariPerDNI(dni);
    }

    @Override
    public List<Usuari> cercarUsuarisPerNom(String nom) {
        return usuariDAO.cercarUsuarisPerNom(nom);
    }

    @Override
    public List<Usuari> cercarUsuarisActius() {
        return usuariDAO.cercarUsuarisActius();
    }

    @Override
    public List<Usuari> cercarUsuarisEntrenadors() {
        return usuariDAO.cercarUsuarisEntrenadors();
    }

    @Override
    public List<Usuari> cercarTotsElsUsuaris() {
        return usuariDAO.cercarTotsElsUsuaris();
    }

  
}

