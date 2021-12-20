/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccessoriDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Accessori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class AccessoriServiceImp implements AccessoriService{
    @Autowired
    private AccessoriDAO accessoriDAO;

    @Transactional
    @Override
    public void crearAccessori(Accessori accessori) {
        accessoriDAO.crearAccessori(accessori);
    }

    @Transactional
    @Override
    public Accessori editarAccessori(Accessori accessori) {
        return accessoriDAO.editarAccessori(accessori);
    }

    @Transactional
    @Override
    public void eliminarAccessori(Accessori accessori) {
        accessoriDAO.eliminarAccessori(accessori);
    }

    @Override
    public Accessori cercarAccessoriPerNom(String nom) {
        return accessoriDAO.cercarAccessoriPerNom(nom);
    }

    @Override
    public List<Accessori> cercarTotsElsAccessoris() {
        return accessoriDAO.cercarTotsElsAccessoris();
    }
    
}
