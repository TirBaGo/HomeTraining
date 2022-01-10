package dao;

import java.util.List;

import model.Usuari;

/**
 * DAO Usuari
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface UsuariDAO {

    /**
     * Crear usuari
     * @param usuari que es vol crear
     */
    public void crearUsuari(Usuari usuari);

    /**
     * Editar usuari
     * @param usuari que es vol editar
     * @return usuari editat
     */
    public Usuari editarUsuari(Usuari usuari);

    /**
     * Eliminar usuari
     * @param usuari que es vol eliminar
     */
    public void eliminarUsuari(Usuari usuari);

    /**
     * Cercar usuari per dni
     * @param dni de l'usuari que es vol cercar
     * @return usuari amb el dni indicat
     */
    public Usuari cercarUsuariPerDNI(String dni);

    /**
     * Cercar usuari per nom
     * @param nom que es ovl cercar
     * @return usuaris amb el nom indicat
     */
    public List<Usuari> cercarUsuarisPerNom(String nom);

    /**
     * cercar usuaris actius
     * @return usuaris acitus
     */
    public List<Usuari> cercarUsuarisActius();

    /**
     * Cercar usuaris entrenadors
     * @return usuaris entrenador true
     */
    public List<Usuari> cercarUsuarisEntrenadors();

    /**
     * Cercar tots els usuaris
     * @return tots els usuaris
     */
    public List<Usuari> cercarTotsElsUsuaris();
    
}