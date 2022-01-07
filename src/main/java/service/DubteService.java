/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Dubte;

/**
 * Service Dubte
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface DubteService {

    /**
     * Crear dubte
     * @param dubte que es vol crear
     */
    public void crearDubte (Dubte dubte);

    /**
     * Editar dubte
     * @param dubte que es vol editar
     * @return dubte editat
     */
    public Dubte editarDubte(Dubte dubte);

    /**
     * Eliminar dubte
     * @param dubte que es vol eliminar
     */
    public void eliminarDubte(Dubte dubte);

    /**
     * Cercar dubte per nom 
     * @param nom del dubte que es vol cercar
     * @return dubte amb el nom indicat
     */
    public Dubte cercarDubtePerNom(String nom);

    /**
     * Cercar dubte per dni d'usuari
     * @param dni_usuari que es vol cercar
     * @return dubtes amb el dni indicat
     */
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari);

    /**
     * Cercar dubte per id 
     * @param id_dubte que es vol cercar
     * @return el dubte amb l'id indicat
     */
    public Dubte cercarDubtePerIdDubte(int id_dubte);

    /**
     * Cerca tots els dubtes
     * @return tots els dubtes
     */
    public List<Dubte> cercarTotsElsDubtes();
    
}
