/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Bug;

/**
 * Service Bug
 * @author Nerea Gallardo 
 * @version 1.0
 */
public interface BugService {

    /**
     * Crear bug
     * @param bug que es vol crear
     */
    public void crearBug (Bug bug);

    /**
     * Editar bug
     * @param bug que es vol editar
     * @return bug editat
     */
    public Bug editarBug(Bug bug);

    /**
     * Eliminar bug
     * @param bug que es vol eliminar
     */
    public void eliminarBug(Bug bug);

    /**
     * Cercar bug per nom 
     * @param nom que es vol cercar
     * @return el bug amb el nom indicat
     */
    public Bug cercarBugPerNom(String nom);

    /**
     * Cercar bug per dni
     * @param dni_usuari que es vol cercar 
     * @return bugs de l'usuari amb el dni indicat
     */
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari);

    /**
     * Cercr bug per id
     * @param id_bug que es vol cercar
     * @return el bug amb l'id indicat
     */
    public Bug cercarBugPerIdBug(int id_bug);

    /**
     * Cercar tots els bugs
     * @return Tots els bugs
     */
    public List<Bug> cercarTotsElsBugs();
    
}
