/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Rutina;

/**
 * Service rutina
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface RutinaService {

    /**
     * Crear rutina
     * @param rutina que es vol crear
     */
    public void crearRutina(Rutina rutina);

    /**
     * EDitar rutina
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
     * @param nom que es vol cercar
     * @return rutina amb el nom indicat
     */
    public Rutina cercarRutinaPerNom(String nom);

    /**
     * Cercar rutina per dni entrenador
     * @param dni_entrenador que es vol cercar
     * @return les rutines amb el dni indicat
     */
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador);

    /**
     * Cercar rutina per modalitat
     * @param nom_modalitat que es vol cercar
     * @return rutines amb la modalitat indicada
     */
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat);

    /**
     * Cercar rutina per accessori
     * @param nom_accessori que es vol cercar
     * @return rutines amb l'accessori indicat
     */
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori);

    /**
     * Cercar rutina activa
     * @return les rutines amb acitve true
     */
    public List<Rutina> cercarRutinaActiva();

    /**
     * Cercar totes les rutines
     * @return totes les rutines
     */
    public List<Rutina> cercarTotesLesRutines();

    /** 
     *  Cercar rutina per nivell
     * @param nivell que es vol cercar
     * @return rutines amb el nivell indicat
     */
    public List<Rutina> cercarRutinaNivell(int nivell);

    /**
     * Cercar rutina per duracio
     * @param duracio que es vol cercar
     * @return rutines amb la duracio indicada
     */
    public List<Rutina> cercarRutinaDuracio(int duracio);

    /**
     * Cercar rutina per preu
     * @param preu que es vol cercar
     * @return les rutines amb el preu indicat
     */
    public List<Rutina> cercarRutinaPreu(double preu);
}
