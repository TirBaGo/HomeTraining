/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RutinaDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.Rutina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class RutinaServiceImp implements RutinaService {
    
    @Autowired
    private RutinaDAO rutinaDAO;

    @Transactional
    @Override
    public void crearRutina(Rutina rutina) {
        rutinaDAO.crearRutina(rutina);
    }

    @Transactional
    @Override
    public Rutina editarRutina(Rutina rutina) {
        return rutinaDAO.editarRutina(rutina);
    }

    @Transactional
    @Override
    public void eliminarRutina(Rutina rutina) {
        rutinaDAO.eliminarRutina(rutina);
    }

    @Override
    public Rutina cercarRutinaPerNom(String nom) {
        return rutinaDAO.cercarRutinaPerNom(nom);
    }

    @Override
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador) {
        return rutinaDAO.cercarRutinaPerDniEnterenador(dni_entrenador);
    }

    @Override
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat) {
        return rutinaDAO.cercarRutinaPerModalitat(nom_modalitat);
    }

    @Override
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori) {
        return rutinaDAO.cercarRutinaPerAccessori(nom_accessori);
    }

    @Override
    public List<Rutina> cercarRutinaActiva() {
        return rutinaDAO.cercarRutinaActiva();
    }

    @Override
    public List<Rutina> cercarTotesLesRutines() {
        return rutinaDAO.cercarTotesLesRutines();

    }

    @Override
    public List<Rutina> cercarRutinaNivell(int nivell) {
        return rutinaDAO.cercarRutinaNivell(nivell);
    }

    @Override
    public List<Rutina> cercarRutinaDuracio(int duracio) {
        return rutinaDAO.cercarRutinaDuracio(duracio);
    }

    @Override
    public List<Rutina> cercarRutinaPreu(double preu) {
        return rutinaDAO.cercarRutinaPreu(preu);
    }
    
    
}
