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
 * Implemntació de Suggeriment Service
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc SuggerimentService
 */
@Service
@Transactional
public class SuggerimentServiceImp implements SuggerimentService{
    
    @Autowired
    private SuggerimentDAO suggerimentDAO;

    /**
     * MEtode que crea el Suggeriment
     * @param suggeriment que es vol crear
     */
    @Transactional
    @Override
    public void crearSuggeriment(Suggeriment suggeriment) {
        suggerimentDAO.crearSuggeriment(suggeriment);
    }

    /**
     * MEtode que edita el Suggeriment
     * @param suggeriment que es vol editar
     * @return Suggeriment editat
     */
    @Transactional
    @Override
    public Suggeriment editarSuggeriment(Suggeriment suggeriment) {
        return suggerimentDAO.editarSuggeriment(suggeriment);
    }

    /**
     * Metode que elimina el Suggeriment
     * @param suggeriment que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarSuggeriment(Suggeriment suggeriment) {
        suggerimentDAO.eliminarSuggeriment(suggeriment);
    }

    /**
     * MEotde que cerca el Suggeriment per nom 
     * @param nom que es vol cercar
     * @return Suggeriment amb el nom indicat
     */
    @Override
    public Suggeriment cercarSuggerimentPerNom(String nom) {
        return suggerimentDAO.cercarSuggerimentPerNom(nom);
    }

    /**
     * MEtode que cerca els Suggeriments per dni de l'usuari creador
     * @param dni_usuari que es vol cercar
     * @return Suggeriments de l'usuari indicat amb el dni
     */
    @Override
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari) {
        return suggerimentDAO.cercarSuggerimentPerDNIUsuari(dni_usuari);
    }

    /**
     * Metode que cerca per l'id
     * @param id_suggeriment que es vol cercar
     * @return el Suggeriment amb l'id indicat
     */
    @Override
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment) {
        return suggerimentDAO.cercarSuggerimentPerIdSuggeriment(id_suggeriment);
    }

    /**
     * Metode que retorna tots els Suggeriments
     * @return tots els Suggeriments
     */
    @Override
    public List<Suggeriment> cercarTotsElsSuggeriments() {
        return suggerimentDAO.cercarTotsElsSuggeriments();
    }
    
}
