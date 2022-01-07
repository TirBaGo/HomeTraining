/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.QueixesDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Queixes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de Queixes Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see QueixesService
 */
@Service
@Transactional
public class QueixesServiceImp implements QueixesService{
    
    @Autowired
    private QueixesDAO queixesDAO;

    /**
     * Metode que crea la queixa 
     * @param queixes que es vol crear
     */
    @Transactional
    @Override
    public void crearQueixa(Queixes queixes) {
        queixesDAO.crearQueixa(queixes);
    }

    /**
     * Metode que edita la queixa
     * @param queixes que es vol editar
     * @return queixa editada
     */
    @Transactional
    @Override
    public Queixes editarQueixa(Queixes queixes) {
        return queixesDAO.editarQueixa(queixes);
    }

    /**
     * MEtode que elimina la queixa
     * @param queixes que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarQueixa(Queixes queixes) {
        queixesDAO.eliminarQueixa(queixes);
    }

    /**
     * MEtode que cerca la quixa per nom
     * @param nom que es vol cercar
     * @return queixa amb el nom indicat
     */
    @Override
    public Queixes cercarQueixaPerNom(String nom) {
        return queixesDAO.cercarQueixaPerNom(nom);
    }

    /**
     * MEtode que cerca les queixes amb el dni del creador
     * @param dni_usuari que es vol cercar
     * @return qqueixes amb el dni de l'usuari creador indicat
     */
    @Override
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari) {
        return queixesDAO.cercarQueixaPerDNIUsuari(dni_usuari);
    }

    /**
     * Metode que cerca les queixes per id
     * @param id_queixes que es vol cercar
     * @return queixa amb l'id indicat
     */
    @Override
    public Queixes cercarQueixaPerIdQueixes(int id_queixes) {
        return queixesDAO.cercarQueixaPerIdQueixes(id_queixes);
    }

    /** 
     * Metode que cerca totes les queixes
     * @return totes les queixes
     */
    @Override
    public List<Queixes> cercarTotesLesQueixes() {
        return queixesDAO.cercarTotesLesQueixes();
    }
    
}
