/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Queixes;

/**
 * Service Queixes
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface QueixesService {

    /**
     * Crear queixes
     * @param queixes que es vol crear
     */
    public void crearQueixa (Queixes queixes);

    /**
     * Editar queixa
     * @param queixes que es vol editar
     * @return queixa editada
     */
    public Queixes editarQueixa(Queixes queixes);

    /**
     * Eliminar queixa
     * @param queixes que es vol eliminar
     */
    public void eliminarQueixa(Queixes queixes);

    /**
     * Cerca queixes per nom 
     * @param nom que es vol cercar
     * @return queixa amb el nom indicat
     */
    public Queixes cercarQueixaPerNom(String nom);

    /**
     * Cercar queixa per dni usuai
     * @param dni_usuari que es vol cercar
     * @return queixes amb el dni indicat
     */
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari);

    /**
     * Cercar queixes per id
     * @param id_queixes que es vol cercar
     * @return queixa amb l'id indicat
     */
    public Queixes cercarQueixaPerIdQueixes(int id_queixes);

    /**
     * Cercar totes les queixes
     * @return totes les queixes
     */
    public List<Queixes> cercarTotesLesQueixes();
}
