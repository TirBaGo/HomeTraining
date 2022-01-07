/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccessoriDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Accessori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de Accessori Service
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc AccessoriService
 */
@Service
@Transactional
public class AccessoriServiceImp implements AccessoriService{
    @Autowired
    private AccessoriDAO accessoriDAO;

    /**
     * Metode que crea l'accessori
     * @param accessori que es vol crear
     */
    @Transactional
    @Override
    public void crearAccessori(Accessori accessori) {
        accessoriDAO.crearAccessori(accessori);
    }

    /**
     * Metode que edita un accessori
     * @param accessori que es vol editar
     * @return accessori editat
     */
    @Transactional
    @Override
    public Accessori editarAccessori(Accessori accessori) {
        return accessoriDAO.editarAccessori(accessori);
    }

    /**
     * Meotde per eliminar un accessori
     * @param accessori que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarAccessori(Accessori accessori) {
        accessoriDAO.eliminarAccessori(accessori);
    }

    /**
     * Metode per cercar accessoris per nom 
     * @param nom que es vol cercar
     * @return accessori amb el nom indicat
     */
    @Override
    public Accessori cercarAccessoriPerNom(String nom) {
        return accessoriDAO.cercarAccessoriPerNom(nom);
    }

    /**
     * Metode que cerca tots els accessoris
     * @return tots els accessoris
     */
    @Override
    public List<Accessori> cercarTotsElsAccessoris() {
        return accessoriDAO.cercarTotsElsAccessoris();
    }
    
}
