/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Bug;

/**
 * DAO Bug
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface BugDAO {

    /**
     * Crear Bug
     * @param bug que es vol crear
     */
    public void crearBug (Bug bug);

    /**
     * Editar Bug
     * @param bug que es vol ediar
     * @return bug editat
     */
    public Bug editarBug(Bug bug);

    /**
     * Eliminar Bug
     * @param bug que es vol eliminar
     */
    public void eliminarBug(Bug bug);

    /**
     * Cercar bug pel nom
     * @param nom del bug que es vol cercar
     * @return bug amb el nom indicat
     */
    public Bug cercarBugPerNom(String nom);

    /**
     * Cercar bug per el dni de l'usuari 
     * @param dni_usuari dni del creador del bug
     * @return bugs amb el dni indicat
     */
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari);

    /**
     * cercar bug per id
     * @param id_bug id del bug que es vol cercar
     * @return el bug que coincideix amb l'id
     */
    public Bug cercarBugPerIdBug(int id_bug);

    /**
     * Cercar tots el bugs
     * @return tots els bugs
     */
    public List<Bug> cercarTotsElsBugs();
    
}
