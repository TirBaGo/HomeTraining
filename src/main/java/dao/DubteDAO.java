/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Dubte;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface DubteDAO {
    public void crearDubte (Dubte dubte);
    public Dubte editarDubte(Dubte dubte);
    public void eliminarDubte(Dubte dubte);
    public Dubte cercarDubtePerNom(String nom);
    public List<Dubte> cercarDubtePerDNIUsuari(String dni_usuari);
    public Dubte cercarDubtePerIdDubte(int id_dubte);
    public List<Dubte> cercarTotsElsDubtes();
}
