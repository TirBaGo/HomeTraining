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
 * Entitat per a bug
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "bug")
public class Bug implements Serializable{
    
    //Variables assocciades a la taula Bug
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name= "id_bug")
    @Id
    private int id_bug;
    
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
     * Metode contsructor per defecte
     */
    public Bug() {
    }

    /**
     * Metode que ens retorna l'id del bug
     * @return Retorna l'id del bug
     */
    public int getId_bug() {
        return id_bug;
    }

    /**
     * Crea l'id del bug
     * @param id_bug id que s'intriduira en bug
     */
    public void setId_bug(int id_bug) {
        this.id_bug = id_bug;
    }

    /**
     * Metode que ens retorna el dni de l'usuari que crea el bug
     * @return Retorna el dni de l'usuari que crea el bug
     */
    public String getDni_usuari() {
        return dni_usuari;
    }

    /**
     * Crea el dni_usuari dins de bug
     * @param dni_usuari dni_usuari que s'intorduira en bug
     */
    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
    }

    /**
     * Metode que ens retorna el nom del bug
     * @return Retorna el nom del bug
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom per al bug
     * @param nom nom que s'introduira en bug
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna la descripció del bug
     * @return Retorna la descripció del bug
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripcio per a bug
     * @param descripcio descricpio que s'intriduira en bug
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}
