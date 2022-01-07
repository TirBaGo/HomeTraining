/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Accessori;

/**
 * DAO Accessori
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface AccessoriDAO {

    /**
     * Crear accessori
     * @param accessori que es vol crear
     */
    public void crearAccessori(Accessori accessori);

    /**
     * Editar Accessori
     * @param accessori que es vol editar
     * @return accessori editat
     */
    public Accessori editarAccessori(Accessori accessori);

    /**
     * Elimiar Accessori
     * @param accessori que es vol eliminar
     */
    public void eliminarAccessori(Accessori accessori);

    /**
     * Cercar accessori per nom
     * @param nom del accessori que es vol cercar
     * @return accessori amb el nom indicat
     */
    public Accessori cercarAccessoriPerNom(String nom);

    /**
     * Cercar tots els accessoris 
     * @return tots els accessoris
     */
    public List<Accessori> cercarTotsElsAccessoris();
     
}
