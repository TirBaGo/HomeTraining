/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ModalitatDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Modalitat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de modalitat service
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc ModalitatService
 */
@Service
@Transactional
public class ModalitatServiceImp implements ModalitatService{
    
    @Autowired
    private ModalitatDAO modalitatDAO;

    /**
     * MEtode que crea la modalitat
     * @param modalitat que es vol crear
     */
    @Transactional
    @Override
    public void crearModalitat(Modalitat modalitat) {
        modalitatDAO.crearModalitat(modalitat);
    }

    /**
     * Metode que edita la modalitat
     * @param modalitat que es vol editar
     * @return modalitat editada
     */
    @Transactional
    @Override
    public Modalitat editarModalitat(Modalitat modalitat) {
        return modalitatDAO.editarModalitat(modalitat);
    }

    /**
     * Eliminar modalitat
     * @param modalitat que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarModalitat(Modalitat modalitat) {
        modalitatDAO.eliminarModalitat(modalitat);
    }

    /**
     * Metode que cerca modalitat per nom 
     * @param nom que es vol cercar
     * @return modalitat amb el nom indicat
     */
    @Override
    public Modalitat cercarModalitatPerNom(String nom) {
        return modalitatDAO.cercarModalitatPerNom(nom);
    }

    /**
     * Metode que cerca totes les modalitats
     * @return totes les modalitats
     */
    @Override
    public List<Modalitat> cercarTotesLesModalitats() {
        return modalitatDAO.cercarTotesLesModalitats();
    }
    
    
}
