/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Suggeriment;

/**
 * Service Suggeriment 
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface SuggerimentService {

    /**
     * Crear suggeriment
     * @param suggeriment que es vol crear 
     */
    public void crearSuggeriment (Suggeriment suggeriment);

    /**
     * Editar Suggeriment
     * @param suggeriment que es vol editar
     * @return Suggeriment editat
     */
    public Suggeriment editarSuggeriment(Suggeriment suggeriment);

    /**
     * Eliminar Suggeriment
     * @param suggeriment que es vol eliminar 
     */
    public void eliminarSuggeriment(Suggeriment suggeriment);

    /**
     * cercar Suggeriment per nom 
     * @param nom que es vol cercar 
     * @return Suggeriment amb el nom indicat
     */
    public Suggeriment cercarSuggerimentPerNom(String nom);

    /**
     * Cercar Suggeriment per dni 
     * @param dni_usuari que es vol cercar
     * @return Suggeriments amb el dni indicat
     */
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari);

    /**
     * Cercar Suggeriments per id
     * @param id_suggeriment que es vol cercar
     * @return Suggeriment amb l'id indicat
     */
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment);

    /** 
     * Cercar tots els Suggeriments
     * @return tots els Suggeriments
     */
    public List<Suggeriment> cercarTotsElsSuggeriments();
}
