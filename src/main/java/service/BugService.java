/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Bug;

/**
 *
 * @author Nerea Gallardo 
 * @version 1.0
 */
public interface BugService {
    public void crearBug (Bug bug);
    public Bug editarBug(Bug bug);
    public void eliminarBug(Bug bug);
    public Bug cercarBugPerNom(String nom);
    public List<Bug> cercarBugPerDNIUsuari(String dni_usuari);
    public Bug cercarBugPerIdBug(int id_bug);
    public List<Bug> cercarTotsElsBugs();
    
}
