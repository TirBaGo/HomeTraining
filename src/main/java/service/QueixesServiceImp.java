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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class QueixesServiceImp implements QueixesService{
    
    @Autowired
    private QueixesDAO queixesDAO;

    @Transactional
    @Override
    public void crearQueixa(Queixes queixes) {
        queixesDAO.crearQueixa(queixes);
    }

    @Transactional
    @Override
    public Queixes editarQueixa(Queixes queixes) {
        return queixesDAO.editarQueixa(queixes);
    }

    @Transactional
    @Override
    public void eliminarQueixa(Queixes queixes) {
        queixesDAO.eliminarQueixa(queixes);
    }

    @Override
    public Queixes cercarQueixaPerNom(String nom) {
        return queixesDAO.cercarQueixaPerNom(nom);
    }

    @Override
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari) {
        return queixesDAO.cercarQueixaPerDNIUsuari(dni_usuari);
    }

    @Override
    public Queixes cercarQueixaPerIdQueixes(int id_queixes) {
        return queixesDAO.cercarQueixaPerIdQueixes(id_queixes);
    }

    @Override
    public List<Queixes> cercarTotesLesQueixes() {
        return queixesDAO.cercarTotesLesQueixes();
    }
    
}
