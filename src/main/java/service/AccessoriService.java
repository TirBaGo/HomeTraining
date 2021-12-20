/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Accessori;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface AccessoriService {
    public void crearAccessori(Accessori accessori);
    public Accessori editarAccessori(Accessori accessori);
    public void eliminarAccessori(Accessori accessori);
    public Accessori cercarAccessoriPerNom(String nom);
    public List<Accessori> cercarTotsElsAccessoris();
    
}
