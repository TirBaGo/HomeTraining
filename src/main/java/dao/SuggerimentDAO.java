/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Suggeriment;

/**
 * DAO Suggeriment
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface SuggerimentDAO {

    /**
     * Crear suggeriment
     * @param suggeriment que es vol crear
     */
    public void crearSuggeriment (Suggeriment suggeriment);

    /**
     * Editar Suggeriment
     * @param suggeriment que es vol editar
     * @return suggeriment editat
     */
    public Suggeriment editarSuggeriment(Suggeriment suggeriment);

    /**
     * Eliminar un suggeriment
     * @param suggeriment que es vol eliminar
     */
    public void eliminarSuggeriment(Suggeriment suggeriment);

    /**
     * Cercar suggeriment per nom
     * @param nom que es vol cercar
     * @return suggeriment amb el nom cercat
     */
    public Suggeriment cercarSuggerimentPerNom(String nom);

    /**
     * Cercar suggeriment per dni
     * @param dni_usuari que es vol cercar
     * @return suggeriments amb el dni de l'usauri creador
     */
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari);

    /**
     * Cercar suggeriment per id
     * @param id_suggeriment que es vol cercar
     * @return suggeriment amb l'id indicada
     */
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment);

    /**
     * cerca tots els suggeriments
     * @return tots els suggeriments
     */
    public List<Suggeriment> cercarTotsElsSuggeriments();
    
}
