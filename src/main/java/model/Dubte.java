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
 * Entitat per a dubte
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "dubte")
public class Dubte implements Serializable{
    
    //Variables assocciades a la taula Dubte
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name= "id_dubte")
    @Id
    private int id_dubte;
    
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
    public Dubte() {
    }

    /**
     * Metode que ens retorna l'id del dubte
     * @return Retorna l'id del dubte
     */
    public int getId_dubte() {
        return id_dubte;
    }

    /**
     * Crea l'id del dubte
     * @param id_dubte id que s'intriduira en dubte
     */
    public void setId_dubte(int id_dubte) {
        this.id_dubte = id_dubte;
    }

    /**
     * Metode que ens retorna el dni de l'usuari que crea el dubte
     * @return Retorna el dni de l'usuari que crea el dubte
     */
    public String getDni_usuari() {
        return dni_usuari;
    }

    /**
     * Crea el dni_usuari dins de dubte
     * @param dni_usuari dni_usuari que s'intorduira en dubte
     */
    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
    }

    /**
     * Metode que ens retorna el nom del dubte
     * @return Retorna el nom del dubte
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom per al dubte
     * @param nom nom que s'introduira en dubte
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna la descripció del dubte
     * @return Retorna la descripció del dubte
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripcio per a dubte
     * @param descripcio descricpio que s'intriduira en dubte
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    
}
