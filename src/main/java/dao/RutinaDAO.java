/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Rutina;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface RutinaDAO {
    public void crearRutina(Rutina rutina);
    public Rutina editarRutina(Rutina rutina);
    public void eliminarRutina(Rutina rutina);
    public Rutina cercarRutinaPerNom(String nom);
    public List<Rutina> cercarRutinaPerDniEnterenador(String dni_entrenador);
    public List<Rutina> cercarRutinaPerModalitat(String nom_modalitat);
    public List<Rutina> cercarRutinaPerAccessori(String nom_accessori);
    public List<Rutina> cercarRutinaActiva();
    public List<Rutina> cercarTotesLesRutines();
    public List<Rutina> cercarRutinaNivell(int nivell);
    public List<Rutina> cercarRutinaDuracio(int duracio);
    public List<Rutina> cercarRutinaPreu(double preu);
    
    
    
}
