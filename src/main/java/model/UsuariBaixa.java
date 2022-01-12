/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitat Usuari Baixa
 * @author Nerea Gallardo
 * @version 1.1
 */
@Entity
@Table(name = "usuaribaixa")
public class UsuariBaixa implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
    @NotNull
    @Column(name = "id_usuaribaixa")
    @Id
    private int id_usuariBaixa;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "dni")
    private String dni;

   
    
    @NotNull
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "cognom1")
    private String cognom1;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "cognom2")
    private String cognom2;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    
    @NotNull
    @Column(name = "telefon")
    private int telefon;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "adreca")
    private String adreca;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "provincia")
    private String provincia;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "poblacio")
    private String poblacio;
    
    @NotNull
    @Column(name = "isentrenador")
    private boolean isEntrenador;
    
    @NotNull
    @Column(name = "data_baixa")
    private Timestamp data_baixa;
    
    

    /**
     * Metode constructor per defecte
     */
    public UsuariBaixa() {
    }

    /**
     * MEtode que ens retorna el dni de l'usuari baixa
     * @return dni usuari baixa
     */
    public String getDNI() {
        return dni;
    }

    /**
     * Metode que crea el dni
     * @param dni dni que s'introduira en usuari baixa
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }

    /**
     * Metode que ens retorna el nom de l'usuari baixa
     * @return nom usuari baixa
     */
    public String getNom() {
        return nom;
    }

    /**
     * Metode que crea el nom de l'usuari baixa
     * @param nom que s'introduira en usuari baixa
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna el primer cognom de l'usuari baixa
     * @return primer cognom  
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Metode que crea el primer cognom de l'usuari baixa
     * @param cognom1 que s'introduira en usuaribaixa
     */
    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    /**
     * Metode que ens retorna el segon cognom de l'usuari baixa
     * @return Segon cognom 
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Metode que crea el segon cognom de l'usuari baixa
     * @param cognom2 que s'introduira en usuari baixa
     */
    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    /**
     * Metode que retorna el mail de l'usuari baixa
     * @return el email de l'usuari baixa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metode que crea el mail de l'usuari baixa
     * @param email que s'introduira en usuari baixa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metode que retorna el telefon de l'usuari baixa
     * @return telefon de l'usuari baixa
     */
    public int getTelefon() {
        return telefon;
    }

    /**
     * Metode que crea el telefon de l'usuari baixa
     * @param telefon que s'introduira en l'usuari baixa
     */
    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    /**
     * MEtode que retorna l'adreça de l'usuari baixa
     * @return l'adreça de l'usuari baixa
     */
    public String getAdreca() {
        return adreca;
    }

    /**
     * Metode que crea l'adreça de l'usuari baixa
     * @param adreca que s'introduira en l'usuari baixa
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Metode que retorna la provincia de l'usuari baixa
     * @return la provincia de l'usuari baixa
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Metode que crea la provincia de l'usuari baixa
     * @param provincia que s'introduira en l'usuari baixa
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Metode que retorna la poblacio de l'usuari baixa
     * @return la població de l'usuari baixa
     */
    public String getPoblacio() {
        return poblacio;
    }

    /**
     * MEtode que crea la poblacio de l'usuari baixa
     * @param poblacio que s'introduira en l'usuari baixa
     */
    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    /**
     * Metode que retorna si l'usuari baixa es entrenador
     * @return true o false
     */
    public boolean isIsEntrenador() {
        return isEntrenador;
    }

    /**
     * Metode que crea si l'usuari baixa es entrenador 
     * @param isEntrenador que s'introduira en l'usuari  baixa(true o false)
     */
    public void setIsEntrenador(boolean isEntrenador) {
        this.isEntrenador = isEntrenador;
    }

    /**
     * MEtode que retorna la data de la baixa de l'usuari baixa
     * @return la data de la baixa
     */
    public Timestamp getData_baixa() {
        return data_baixa;
    }

    /**
     * Metode que crea la data de la baixa de l'usuari baixa
     * @param data_baixa que s'introduira en l'usuaribaixa
     */
    public void setData_baixa(Timestamp data_baixa) {
        this.data_baixa = data_baixa;
    }


    /**
     * Metode que retorna l'id de l'usuari baixa
     * @return l'id de l'usuari baixa
     */
    public int getId_usuariBaixa() {
        return id_usuariBaixa;
    }

    /**
     * Metode que crea l'id de l'usuari baixa
     * @param id_usuariBaixa que s'introduira en l'usuari baixa
     */
    public void setId_usuariBaixa(int id_usuariBaixa) {
        this.id_usuariBaixa = id_usuariBaixa;
    }
    
}
