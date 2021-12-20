/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Suggeriment;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface SuggerimentDAO {
    public void crearSuggeriment (Suggeriment suggeriment);
    public Suggeriment editarSuggeriment(Suggeriment suggeriment);
    public void eliminarSuggeriment(Suggeriment suggeriment);
    public Suggeriment cercarSuggerimentPerNom(String nom);
    public List<Suggeriment> cercarSuggerimentPerDNIUsuari(String dni_usuari);
    public Suggeriment cercarSuggerimentPerIdSuggeriment(int id_suggeriment);
    public List<Suggeriment> cercarTotsElsSuggeriments();
    
}
