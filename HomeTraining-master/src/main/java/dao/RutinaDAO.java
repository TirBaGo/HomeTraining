/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Rutina;

/**
 * DAO Rutina
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface RutinaDAO {

    /**
     * Crear rutina
     * @param rutina que es vol crear
     */
    public void crearRutina(Rutina rutina);

    /**
     * Editar rutina
     * @param rutina que es vol editar
     * @return rutina editada
     */
    public Rutina editarRutina(Rutina rutina);

    /**
     * Eliminar rutina 
     * @param rutina que es vol eliminar
     */
    public void eliminarRutina(Rutina rutina);

    /**
     * Cercar rutina per nom
     * @param nom de la rutina que es vol cercar
     * @return rutina amb el nom indicat
     */
    public Rutina cercarRutinaPerNom(String nom);

    /**
     * Cercar rutina per dni entrenador
     * @param dni_entrenador que es vol cercar les seves rutines
     * @return rutines del entrenador amb el dni indicat
     */
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador);

    /**
     * Cercar rutina per modalitat
     * @param nom_modalitat modalitat que es vol cercar
     * @return rutines amb la modalitat indicada
     */
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat);

    /**
     * Cercar rutina per accessori
     * @param nom_accessori nom de l'accessori que es vol cercar
     * @return rutines amb l'accessori indicat
     */
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori);

    /**
     * Cercar rutines actives
     * @return rutines amb acitve true
     */
    public List<Rutina> cercarRutinaActiva();

    /**
     * Cercar totes les rutines
     * @return totes les rutines
     */
    public List<Rutina> cercarTotesLesRutines();

    /**
     * Cercar rutina per nivell
     * @param nivell que es vol cercar
     * @return rutines amb el nivell indicat
     */
    public List<Rutina> cercarRutinaNivell(int nivell);

    /**
     * Cercar rutina per duracio
     * @param duracio que es vol cercar
     * @return rutines amb la duració indicada
     */
    public List<Rutina> cercarRutinaDuracio(int duracio);

    /**
     * Cerca rutina per preu
     * @param preu que es vol cercar
     * @return rutines amb el preu indicat
     */
    public List<Rutina> cercarRutinaPreu(double preu);
    
    
    
}
