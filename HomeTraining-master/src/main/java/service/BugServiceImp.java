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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class BugServiceImp implements BugService{
    
    @Autowired
    private BugDAO bugDAO;

    @Transactional
    @Override
    public void crearBug(Bug bug) {
        bugDAO.crearBug(bug);
    }

    @Transactional
    @Override
    public Bug editarBug(Bug bug) {
        return bugDAO.editarBug(bug);
    }

    @Transactional
    @Override
    public void eliminarBug(Bug bug) {
        bugDAO.eliminarBug(bug);
    }

    @Override
    public Bug cercarBugPerNom(String nom) {
        return bugDAO.cercarBugPerNom(nom);
    }

    @Override
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari) {
        return  bugDAO.cercarBugPerDNIUsuari(dni_usuari);
    }

    @Override
    public Bug cercarBugPerIdBug(int id_bug) {
        return bugDAO.cercarBugPerIdBug(id_bug);
    }

    @Override
    public List<Bug> cercarTotsElsBugs() {
        return bugDAO.cercarTotsElsBugs();
    }
    
}
