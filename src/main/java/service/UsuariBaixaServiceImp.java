/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuariBaixaDAO;
import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import model.UsuariBaixa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de usuariBaixa Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see UsuariBaixaService
 */
@Service
@Transactional
public class UsuariBaixaServiceImp implements UsuariBaixaService{

     @Autowired
    private UsuariBaixaDAO usuariBaixaDAO;

    /**
     * Metode que crea usuaris
     * @param usuariBaixa que es vol crear
     */
    @Transactional
    @Override
    public void crearUsuariBaixa(UsuariBaixa usuariBaixa) {
        usuariBaixaDAO.crearUsuariBaixa(usuariBaixa);
    }

    /**
     * MEtode que edita usuaris
     * @param usuariBaixa que es vol editar
     * @return usuari editat
     */
    @Transactional
    @Override
    public UsuariBaixa editarUsuariBaixa( UsuariBaixa usuariBaixa) {
        return usuariBaixaDAO.editarUsuariBaixa(usuariBaixa);
    }

    /**
     * Metode que elimina usuari 
     * @param usuariBaixa que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarUsuariBaixa(UsuariBaixa usuariBaixa) {
        usuariBaixaDAO.eliminarUsuariBaixa(usuariBaixa);
    }

    /**
     * Metode que cerca usuaris per dni
     * @param dni que es vol cercar
     * @return l'usuari amb el dni indicat
     */
    @Override
    public UsuariBaixa cercarUsuariBaixaPerDNI(String dni) {
        return usuariBaixaDAO.cercarUsuariBaixaPerDNI(dni);
    }

    /**
     * Metode que cerca usuaris per nom 
     * @param nom que es vol cercar
     * @return usuaris amb el nom indicat
     */
    @Override
    public List<UsuariBaixa> cercarUsuarisBaixaPerNom(String nom) {
        return usuariBaixaDAO.cercarUsuarisBaixaPerNom(nom);
    }

    /**
     * Metode per cercar usuariBaixa per data baixa
     * @param data_baixa que es vol cercar
     * @return usuariBaixa amb la data indicada
     */
    @Override
    public List<UsuariBaixa> cercarUsuariBaixaPerDataBaixa(Timestamp data_baixa) {
        return usuariBaixaDAO.cercarUsuariBaixaPerDataBaixa(data_baixa);
    }

    /**
     * Metode que cerca usuaris entrenadors 
     * @return usuaris amb entrenador en true
     */
    @Override
    public List<UsuariBaixa> cercarUsuarisBaixaEntrenadors() {
        return usuariBaixaDAO.cercarUsuarisBaixaEntrenadors();
    }

    /**
     * MEtode que cerca tots els usuaris
     * @return tots els usuaris
     */
    @Override
    public List<UsuariBaixa> cercarTotsElsUsuarisBaixa() {
        return usuariBaixaDAO.cercarTotsElsUsuarisBaixa();
    }


   

    
    
}
