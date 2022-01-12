/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.UsuariBaixa;

/**
 * DAO UsuariBaixa
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface UsuariBaixaDAO {
    /**
     * Crear usuari Baixa
     * @param usuariBaixa que es vol crear
     */
    public void crearUsuariBaixa(UsuariBaixa usuariBaixa);

    /**
     * Editar usuari Baixa
     * @param usuariBaixa que es vol editar
     * @return usuari editat
     */
    public UsuariBaixa editarUsuariBaixa(UsuariBaixa usuariBaixa);

    /**
     * Eliminar usuari Baixa
     * @param usuariBaixa que es vol eliminar
     */
    public void eliminarUsuariBaixa(UsuariBaixa usuariBaixa);

    /**
     * Cercar usuari Baixa per dni
     * @param dni de l'usuariBaixa que es vol cercar
     * @return usuariBaixa amb el dni indicat
     */
    public UsuariBaixa cercarUsuariBaixaPerDNI(String dni);

    /**
     * Cercar usuari Baixa per nom
     * @param nom que es vol cercar
     * @return usuarisBaixa amb el nom indicat
     */
    public List<UsuariBaixa> cercarUsuarisBaixaPerNom(String nom);

    /**
     * Cercar usuariBaixa per data baixa
     * @param data_baixa que es vol cercar
     * @return usuariBaixa amb la data indicada
     */
    public List<UsuariBaixa> cercarUsuariBaixaPerDataBaixa(Timestamp data_baixa);

    /**
     * Cercar usuarisBaixa entrenadors
     * @return usuaris Baixa entrenador true
     */
    public List<UsuariBaixa> cercarUsuarisBaixaEntrenadors();

    /**
     * Cercar tots els usuaris
     * @return tots els usuaris
     */
    public List<UsuariBaixa> cercarTotsElsUsuarisBaixa();
    
}
