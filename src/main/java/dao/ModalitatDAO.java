/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Modalitat;

/**
 *
 * @author Nerea Gallardo 
 * @version 1.0
 */
public interface ModalitatDAO {
    public void crearModalitat(Modalitat modalitat);
    public Modalitat editatModalitat(Modalitat modalitat);
    public void eliminarModalitat(Modalitat modalitat);
    public Modalitat cercarModalitatPerNom(String nom);
    public List<Modalitat> cercarTotesLesModalitats();
    
}
