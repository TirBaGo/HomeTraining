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
 * Implemenbtació de Rutina Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see RutinaService
 */
@Service
@Transactional
public class RutinaServiceImp implements RutinaService {
    
    @Autowired
    private RutinaDAO rutinaDAO;

    /**
     * MEtode que crea la rutina
     * @param rutina que es vol crear
     */
    @Transactional
    @Override
    public void crearRutina(Rutina rutina) {
        rutinaDAO.crearRutina(rutina);
    }

    /**
     * Metode que edita la rutina
     * @param rutina que es vol editar
     * @return rutina editada
     */
    @Transactional
    @Override
    public Rutina editarRutina(Rutina rutina) {
        return rutinaDAO.editarRutina(rutina);
    }

    /**
     * Meode que elimina la rutina 
     * @param rutina que es vol eliminar 
     */
    @Transactional
    @Override
    public void eliminarRutina(Rutina rutina) {
        rutinaDAO.eliminarRutina(rutina);
    }

    /**
     * Metode que cerca la rutina per nom
     * @param nom que es vol cercar
     * @return rutina amb el nom indicat
     */
    @Override
    public Rutina cercarRutinaPerNom(String nom) {
        return rutinaDAO.cercarRutinaPerNom(nom);
    }

    /**
     * MEtode que cerca la rutina per el dni de l'entrenador
     * @param dni_entrenador que es vol cercar
     * @return les rutines amb el dni de l'entrenador indicat
     */
    @Override
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador) {
        return rutinaDAO.cercarRutinaPerDniEnterenador(dni_entrenador);
    }

    /**
     * MEtode que cerca les rutines per modalitat
     * @param nom_modalitat que es vol cercar
     * @return les rutines amb la modalitat indicada
     */
    @Override
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat) {
        return rutinaDAO.cercarRutinaPerModalitat(nom_modalitat);
    }

    /**
     * MEtode que cerca les rutines per accessori
     * @param nom_accessori que es vol cercar 
     * @return rutines amb l'accessori indicat
     */
    @Override
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori) {
        return rutinaDAO.cercarRutinaPerAccessori(nom_accessori);
    }

    /**
     * Metode que cerca les rutines actives
     * @return les rutines amb acitve true
     */
    @Override
    public List<Rutina> cercarRutinaActiva() {
        return rutinaDAO.cercarRutinaActiva();
    }

    /**
     * Metode que cerca totes les rutines
     * @return totes les rutines
     */
    @Override
    public List<Rutina> cercarTotesLesRutines() {
        return rutinaDAO.cercarTotesLesRutines();

    }

    /**
     * MEtode que cerca les rutines per nivell 
     * @param nivell que es vol cercar
     * @return rutines amb el nivell indicat
     */
    @Override
    public List<Rutina> cercarRutinaNivell(int nivell) {
        return rutinaDAO.cercarRutinaNivell(nivell);
    }

    /**
     * Metode que cerca les rutines per duracio
     * @param duracio que es vol cercar
     * @return rutines amb la duracio indicada
     */
    @Override
    public List<Rutina> cercarRutinaDuracio(int duracio) {
        return rutinaDAO.cercarRutinaDuracio(duracio);
    }

    /**
     * Metode que cerca les rutines per preu
     * @param preu que es vol cercar
     * @return les rutines amb el preu indicat
     */
    @Override
    public List<Rutina> cercarRutinaPreu(double preu) {
        return rutinaDAO.cercarRutinaPreu(preu);
    }
    
    
}
