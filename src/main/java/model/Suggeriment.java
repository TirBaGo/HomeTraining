/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitat per a la taula suggeriment
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "suggeriment")
public class Suggeriment implements Serializable{
    
    //Variables assocciades a la taula rutina
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name= "id_suggeriment")
    @Id
    private int id_suggeriment;
    
    @NotNull
    @Size(max = 9)
    @Column( name = "dni_usuari")
    private String dni_usuari;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "descripcio")
    private String descripcio;

    /**
     * Metode constructor per defecte
     */
    public Suggeriment() {
    }

    /**
     * Metode que ens retorna l'id del suggeriment
     * @return Retorna l'id del suggeriment
     */
    public int getId_suggeriment() {
        return id_suggeriment;
    }

    /**
     * Crea l'id del suggeriment
     * @param id_suggeriment id que s'intriduira en suggeriment
     */
    public void setId_suggeriment(int id_suggeriment) {
        this.id_suggeriment = id_suggeriment;
    }

    /**
     * Metode que ens retorna el dni del suggeriment
     * @return Retorna el dni del suggeriment
     */
    public String getDni_usuari() {
        return dni_usuari;
    }

    /**
     * Crea el dni de l'usuari del suggeriment
     * @param dni_usuari dni que s'intriduira en suggeriment
     */
    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
    }

    /**
     * Metode que ens retorna el nom del suggeriment
     * @return Retorna el nom del suggeriment
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom de l'usuari del suggeriment
     * @param nom nom que s'intriduira en suggeriment
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna la descripció del suggeriment
     * @return Retorna la descripció del suggeriment
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripció de l'usuari del suggeriment
     * @param descripcio descripció que s'intriduira en suggeriment
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}
