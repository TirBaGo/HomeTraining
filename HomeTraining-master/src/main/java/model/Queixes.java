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
 * Entitat per a la taula queixes
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "queixes")
public class Queixes implements Serializable{
    
    //Variables assocciades a la taula queixes
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name= "id_queixes")
    @Id
    private int id_queixes;
    
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
    public Queixes() {
    }

    /**
     * Metode que ens retorna l'id de la queixa
     * @return Retorna l'id de la queixa
     */
    public int getId_queixes() {
        return id_queixes;
    }

    /**
     * Crea l'id de la queixa
     * @param id_queixes id que s'intriduira en queixes
     */
    public void setId_queixes(int id_queixes) {
        this.id_queixes = id_queixes;
    }

    /**
     * Metode que ens retorna el dni de l'usuari que crea la queixa
     * @return Retorna el dni de l'usuari que crea la queixa
     */
    public String getDni_usuari() {
        return dni_usuari;
    }

    /**
     * Crea el dni_usuari dins de queixa
     * @param dni_usuari dni_usuari que s'intorduira en queixa
     */
    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
    }

    /**
     * Metode que ens retorna el nom de la queixa
     * @return Retorna el nom de la queixa
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom per a la queixa
     * @param nom nom que s'introduira en queixa
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna la descripció de la queixa
     * @return Retorna la descripció de la queixa
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripcio per a queixa
     * @param descripcio descricpio que s'intriduira en queixa
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

}
