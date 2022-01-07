package service;

import java.util.List;

import model.Usuari;

/**
 * Service usuari
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface UsuariService {

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
     * @param dni que es vol cercar 
     * @return usuari amb el dni indicat
     */
    public Usuari cercarUsuariPerDNI(String dni);

    /**
     * Cercar usuari per nom 
     * @param nom que es vol cercar
     * @return usuaris amb el nom indicat
     */
    public List<Usuari> cercarUsuarisPerNom(String nom);

    /**
     * Cercar usuaris actius
     * @return usuaris amb actiu true
     */
    public List<Usuari> cercarUsuarisActius();

    /**
     * Cercar usuaris entrenadors
     * @return usuaris amb entrenador true
     */
    public List<Usuari> cercarUsuarisEntrenadors();

    /**
     * Cercar tots els usuaris
     * @return tots els usuaris
     */
    public List<Usuari> cercarTotsElsUsuaris();
}
