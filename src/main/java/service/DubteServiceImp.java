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
 * Implementació de Dubte Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see DubteService
 */
@Service
@Transactional
public class DubteServiceImp implements DubteService{
    
    @Autowired
    private DubteDAO dubteDAO;

    /**
     * Metode que crea el dubte
     * @param dubte que es vol crear
     */
    @Transactional
    @Override
    public void crearDubte(Dubte dubte) {
        dubteDAO.crearDubte(dubte);
    }

    /**
     * Metode que edita el dubte
     * @param dubte que es vol editar
     * @return dubte editat
     */
    @Transactional
    @Override
    public Dubte editarDubte(Dubte dubte) {
        return dubteDAO.editarDubte(dubte);
    }

    /**
     * Metode que elimina el dubte
     * @param dubte que es vol eliminar
     */
    @Transactional 
    @Override
    public void eliminarDubte(Dubte dubte) {
        dubteDAO.eliminarDubte(dubte);
    }

    /**
     * MEtode que cerca el dubte pel nom 
     * @param nom del dubte que es vol cercar
     * @return el dubte amb el nom indicat
     */
    @Override
    public Dubte cercarDubtePerNom(String nom) {
        return dubteDAO.cercarDubtePerNom(nom);
    }

    /**
     * MEtode que cerca els dubtes pel dni del creador
     * @param dni_usuari que es vol cercar
     * @return dubtes de l'usuari amb el dni indicat
     */
    @Override
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari) {
        return dubteDAO.cercarDubtePerDNIUsuari(dni_usuari);
    }

    /**
     * Metode que cerca el dubte per l'id
     * @param id_dubte que es vol cercar
     * @return dubte amb l'id indicat
     */
    @Override
    public Dubte cercarDubtePerIdDubte(int id_dubte) {
        return dubteDAO.cercarDubtePerIdDubte(id_dubte);
    }

    /**
     * Metode que cerca tots els dubtes
     * @return tots els dubtes
     */
    @Override
    public List<Dubte> cercarTotsElsDubtes() {
        return dubteDAO.cercarTotsElsDubtes();
    }
    
}
