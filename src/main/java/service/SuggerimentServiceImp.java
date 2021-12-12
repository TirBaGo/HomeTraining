/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.SuggerimentDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Suggeriment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class SuggerimentServiceImp implements SuggerimentService{
    
    @Autowired
    private SuggerimentDAO suggerimentDAO;

    @Transactional
    @Override
    public void crearSuggeriment(Suggeriment suggeriment) {
        suggerimentDAO.crearSuggeriment(suggeriment);
    }

    @Transactional
    @Override
    public Suggeriment editarSuggeriment(Suggeriment suggeriment) {
        return suggerimentDAO.editarSuggeriment(suggeriment);
    }

    @Transactional
    @Override
    public void eliminarSuggeriment(Suggeriment suggeriment) {
        suggerimentDAO.eliminarSuggeriment(suggeriment);
    }

    @Override
    public Suggeriment cercarSuggerimentPerNom(String nom) {
        return suggerimentDAO.cercarSuggerimentPerNom(nom);
    }

    @Override
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari) {
        return suggerimentDAO.cercarSuggerimentPerDNIUsuari(dni_usuari);
    }

    @Override
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment) {
        return suggerimentDAO.cercarSuggerimentPerIdSuggeriment(id_suggeriment);
    }

    @Override
    public List<Suggeriment> cercarTotsElsSuggeriments() {
        return suggerimentDAO.cercarTotsElsSuggeriments();
    }
    
}
