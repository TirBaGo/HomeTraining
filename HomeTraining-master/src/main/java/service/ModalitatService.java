/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Modalitat;

/**
 * Service modalitat
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface ModalitatService {

    /**
     * Crear modalitat
     * @param modalitat que es vol crear
     */
    public void crearModalitat(Modalitat modalitat);

    /**
     * Editar modalitat
     * @param modalitat que es vol editar
     * @return modalitat editada
     */
    public Modalitat editarModalitat(Modalitat modalitat);

    /**
     * Eliminar modalitat
     * @param modalitat que es vol eliminar
     */
    public void eliminarModalitat(Modalitat modalitat);

    /**
     * Cercar modalitat per nom 
     * @param nom que es vol cercar
     * @return modalitat amb el nom indicat
     */
    public Modalitat cercarModalitatPerNom(String nom);

    /**
     * Cercar totes les modalitas
     * @return totes les modalitats
     */
    public List<Modalitat> cercarTotesLesModalitats();
    
}
