package dao;

import java.util.List;

import model.Usuari;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface UsuariDAO {
    public void crearUsuari(Usuari usuari);
    public Usuari editarUsuari(Usuari usuari);
    public void eliminarUsuari(Usuari usuari);
    public Usuari cercarUsuariPerDNI(String dni);
    public List<Usuari> cercarUsuarisPerNom(String nom);
    public List<Usuari> cercarUsuarisActius();
    public List<Usuari> cercarUsuarisEntrenadors();
    public List<Usuari> cercarTotsElsUsuaris();
    
}