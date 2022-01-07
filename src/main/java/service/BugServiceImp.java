/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BugDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de Bug Service
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc BugService
 */
@Service
@Transactional
public class BugServiceImp implements BugService{
    
    @Autowired
    private BugDAO bugDAO;

    /**
     * Metode que crea el bug
     * @param bug que es vol crear
     */
    @Transactional
    @Override
    public void crearBug(Bug bug) {
        bugDAO.crearBug(bug);
    }

    /**
     * Metode que edita el bug
     * @param bug que es vol editar 
     * @return bug editat
     */
    @Transactional
    @Override
    public Bug editarBug(Bug bug) {
        return bugDAO.editarBug(bug);
    }

    /**
     * Metode que elimina el bug
     * @param bug que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarBug(Bug bug) {
        bugDAO.eliminarBug(bug);
    }

    /**
     * Metode que cerca els bugs per nom
     * @param nom del bug que es vol cercar
     * @return el bug amb el nom indicat
     */
    @Override
    public Bug cercarBugPerNom(String nom) {
        return bugDAO.cercarBugPerNom(nom);
    }

    /**
     * Metode que cerca els bugs per dni de l'usuari creador
     * @param dni_usuari que es vol cercar
     * @return els bugs de l'usuari indicat amb el dni
     */
    @Override
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari) {
        return  bugDAO.cercarBugPerDNIUsuari(dni_usuari);
    }

    /**
     * Metode que cerca els bugs per id
     * @param id_bug que es vol cercar
     * @return bug amb l'id indicat
     */
    @Override
    public Bug cercarBugPerIdBug(int id_bug) {
        return bugDAO.cercarBugPerIdBug(id_bug);
    }

    /**
     * Metode que cerca tots els bugs
     * @return tots els bugs
     */
    @Override
    public List<Bug> cercarTotsElsBugs() {
        return bugDAO.cercarTotsElsBugs();
    }
    
}
