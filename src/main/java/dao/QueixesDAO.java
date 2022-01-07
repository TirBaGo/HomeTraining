/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Queixes;

/**
 * DAO Queixes
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface QueixesDAO {

    /**
     * Crear queixa
     * @param queixes que es vol crear
     */
    public void crearQueixa (Queixes queixes);

    /**
     * Editar Queixes
     * @param queixes que es vol editar
     * @return Queixa editada
     */
    public Queixes editarQueixa(Queixes queixes);

    /**
     * Eliminar queixa
     * @param queixes que es vol editar
     */
    public void eliminarQueixa(Queixes queixes);

    /**
     * Cerca queixa per nom
     * @param nom de la queixa que es vol cercar
     * @return queixa amb el nom indicat
     */
    public Queixes cercarQueixaPerNom(String nom);

    /** 
     * Cercar queixa per dni
     * @param dni_usuari de l'usuari que va crear la queixa
     * @return les queixes amb el dni indicat per parametre
     */
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari);

    /**
     * Cerca queixa per id
     * @param id_queixes que vols cercar
     * @return queixa amb l'i indicat
     */
    public Queixes cercarQueixaPerIdQueixes(int id_queixes);

    /**
     * Cercar totes les queixes
     * @return totes les queixes
     */
    public List<Queixes> cercarTotesLesQueixes();
    
}
