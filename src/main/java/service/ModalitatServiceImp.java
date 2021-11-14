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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */

@Service
@Transactional
public class ModalitatServiceImp implements ModalitatService{
    
    @Autowired
    private ModalitatDAO modalitatDAO;

    @Transactional
    @Override
    public void crearModalitat(Modalitat modalitat) {
        modalitatDAO.crearModalitat(modalitat);
    }

    @Transactional
    @Override
    public Modalitat editatModalitat(Modalitat modalitat) {
        return modalitatDAO.editatModalitat(modalitat);
    }

    @Transactional
    @Override
    public void eliminarModalitat(Modalitat modalitat) {
        modalitatDAO.eliminarModalitat(modalitat);
    }

    @Override
    public Modalitat cercarModalitatPerNom(String nom) {
        return modalitatDAO.cercarModalitatPerNom(nom);
    }

    @Override
    public List<Modalitat> cercarTotesLesModalitats() {
        return modalitatDAO.cercarTotesLesModalitats();
    }
    
}
