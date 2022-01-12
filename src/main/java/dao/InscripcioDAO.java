/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.Inscripcio;

/**
 * DAO Inscricpio
 * @author Nerea Gallardo 
 * @version 1.0
 */
public interface InscripcioDAO {

    /**
     * Crear Inscripcio
     * @param inscripcio que es vol crear
     */
    public void crearInscripcio(Inscripcio inscripcio);

    /**
     * Editar Inscripcio
     * @param inscripcio que es vol editar
     * @return inscripcio editada
     */
    public Inscripcio editarInscripcio (Inscripcio inscripcio);

    /**
     * Eliminar inscripcio
     * @param inscripcio que es vol eliminar
     */
    public void eliminarInscripcio(Inscripcio inscripcio);

    /**
     * Cercar inscripcio per dni
     * @param dni que es vol cercar
     * @return inscripcions amb el dni indicat
     */
    public List<Inscripcio> cercarInscripcioPerDNI (String dni);

    /**
     * Cercar inscripcio per id
     * @param id_inscripcio que es vol cercar
     * @return inscripcio amb l'id indicat
     */
    public Inscripcio cercarInscripcioPerId(int id_inscripcio);

    /**
     * Cercar inscripcio per nom rutina 
     * @param nom_rutina que es vol cercar
     * @return inscripcions amb el nom rutina indicat
     */
    public List<Inscripcio> cercarInscripcioPerNomRutina(String nom_rutina);

    /**
     * Cercar inscripcio is pagat true
     * @return inscripcions que tinguin pagat en true
     */
    public List<Inscripcio> cercarInscripcioPerIspagat ();
    
    /**
     * Cercar inscripcio is pagat false
     * @return inscripcions que tinguin pagat en false
     */
    public List<Inscripcio> cercarInscripcioPerFalseIspagat ();

    /**
     * Cercar inscripcions per data d'alta
     * @param data_alta que es vol cercar
     * @return inscripcions amb la data indicada
     */
    public List<Inscripcio> cercarInscripcioPerDataAlta(Timestamp data_alta);

    /**
     * Cercar inscripcio per data fi
     * @param data_fi que es vol cercar
     * @return Inscripcions amb la data indicada
     */
    public List<Inscripcio> cercarInscripcioPerDataFi(Timestamp data_fi);

    /**
     * Cerca totes les inscripcions
     * @return totes les inscripcions
     */
    public List<Inscripcio> cercarTotesLesInscripcions();
    
    
}
