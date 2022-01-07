/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Accessori;

/**
 * Service Accessori 
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface AccessoriService {

    /**
     * Crea accessori
     * @param accessori que es vol crear
     */
    public void crearAccessori(Accessori accessori);

    /**
     * Editar accessori
     * @param accessori que es vol editar
     * @return accessori editat
     */
    public Accessori editarAccessori(Accessori accessori);

    /**
     * Eliminar Accessori
     * @param accessori que es vol eliminar
     */
    public void eliminarAccessori(Accessori accessori);

    /**
     * Cercar accessori per nom 
     * @param nom que es vol cercar
     * @return accessori amb el nom cercat
     */
    public Accessori cercarAccessoriPerNom(String nom);

    /**
     * Cercar tots els accessoris
     * @return tots els accessoris
     */
    public List<Accessori> cercarTotsElsAccessoris();
    
}
