/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuari;

import java.util.List;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface UsuariDAO {
    public void crearUsuari(Usuari usuari);
    public Usuari editarUsuari(Usuari usuari);
    public void eliminarUsuari(Usuari usuari);
    public Usuari cercarUsuariPerDNI(String DNI);
    public List<Usuari> cercarUsuarisPerNom(String nom);
    public List<Usuari> cercarUsuarisActius();
    public List<Usuari> cercarUsuarisEntrenadors();
    public List<Usuari> cercarTotsElsUsuaris();
    
}
