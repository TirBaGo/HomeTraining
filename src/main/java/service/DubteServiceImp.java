/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DubteDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Dubte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class DubteServiceImp implements DubteService{
    
    @Autowired
    private DubteDAO dubteDAO;

     @Transactional
    @Override
    public void crearDubte(Dubte dubte) {
        dubteDAO.crearDubte(dubte);
    }

     @Transactional
    @Override
    public Dubte editarDubte(Dubte dubte) {
        return dubteDAO.editarDubte(dubte);
    }

     @Transactional 
    @Override
    public void eliminarDubte(Dubte dubte) {
        dubteDAO.eliminarDubte(dubte);
    }

    @Override
    public Dubte cercarDubtePerNom(String nom) {
        return dubteDAO.cercarDubtePerNom(nom);
    }

    @Override
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari) {
        return dubteDAO.cercarDubtePerDNIUsuari(dni_usuari);
    }

    @Override
    public Dubte cercarDubtePerIdDubte(int id_dubte) {
        return dubteDAO.cercarDubtePerIdDubte(id_dubte);
    }

    @Override
    public List<Dubte> cercarTotsElsDubtes() {
        return dubteDAO.cercarTotsElsDubtes();
    }
    
}
