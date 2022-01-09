/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InscripcioDAO;
import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import model.Inscripcio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementació de inscripció Service
 * @author Nerea Gallardo
 * @version 1.0
 * @see InscripcioService
 */
@Service
@Transactional
public class InscripcioServiceImp implements InscripcioService{

    @Autowired
    private InscripcioDAO inscripcioDAO;
    
    /**
     * Metode que crea una inscripcio
     * @param inscripcio que es vol crear
     */
    @Transactional
    @Override
    public void crearInscripcio(Inscripcio inscripcio) {
        inscripcioDAO.crearInscripcio(inscripcio);
    }

    /**
     * Metode que edita una inscripcio
     * @param inscripcio que es vol crear
     * @return inscripcio editada
     */
    @Transactional
    @Override
    public Inscripcio editarInscripcio(Inscripcio inscripcio) {
        return inscripcioDAO.editarInscripcio(inscripcio);
    }

    /**
     * Metode que elimina una inscripcio
     * @param inscripcio que es vol crear
     */
    @Transactional
    @Override
    public void eliminarInscripcio(Inscripcio inscripcio) {
        inscripcioDAO.eliminarInscripcio(inscripcio);
    }

    /**
     * Metode que cerca inscripcions per dni
     * @param dni que es vol cercar
     * @return inscripcions amb el dni indicat
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDNI(String dni) {
        return inscripcioDAO.cercarInscripcioPerDNI(dni);
    }

    /**
     * Metode que cerca una inscripcio per id
     * @param id_inscripcio que es vol cercar
     * @return inscripcio amb l'id indicat
     */
    @Override
    public Inscripcio cercarInscripcioPerId(int id_inscripcio) {
        return inscripcioDAO.cercarInscripcioPerId(id_inscripcio);
    }

    /**
     * Metode que cerca inscripcions per nom rutina 
     * @param nom_rutina que es vol cercar
     * @return inscripcions amb el nom rutina indicat
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerNomRutina(String nom_rutina) {
        return inscripcioDAO.cercarInscripcioPerNomRutina(nom_rutina);
    }

    /**
     * MEtode que cerca inscripcions amb is pagat true
     * @return inscripcions que tinguin pagat en true
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerIspagat() {
        return inscripcioDAO.cercarInscripcioPerIspagat();
    }

    /**
     * Metode que cerca inscripcions amb is pagat false
     * @return inscripcions que tinguin pagat en false
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerFalseIspagat() {
        return inscripcioDAO.cercarInscripcioPerFalseIspagat();
    }

    /**
     * Metode que cerca inscripcions per data d'alta
     * @param data_alta que es vol cercar
     * @return inscripcions amb la data indicada
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDataAlta(Timestamp data_alta) {
        return inscripcioDAO.cercarInscripcioPerDataAlta(data_alta);
    }

    /**
     * MEtode que cerca inscripcions per data fi
     * @param data_fi que es vol cercar
     * @return Inscripcions amb la data indicada
     */
    @Override
    public List<Inscripcio> cercarInscripcioPerDataFi(Timestamp data_fi) {
        return inscripcioDAO.cercarInscripcioPerDataFi(data_fi);
    }

    /**
     * Metode que cerca totes les inscripcions
     * @return totes les inscripcions
     */
    @Override
    public List<Inscripcio> cercarTotesLesInscripcions() {
        return inscripcioDAO.cercarTotesLesInscripcions();
    }
    
}
