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
 * Entitat per a la taula modalitat
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "modalitat")
public class Modalitat implements Serializable{
    
    //Variables assocciades a la taula modalitat
    
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "nom")
    @Size(max = 255)
    @Id
    private String nom;
    
    @NotNull
    @Column(name = "descripcio")
    @Size(max = 255)
    private String descripcio;

    /**
     * Metode constructor per defecte
     */
    public Modalitat() {
    }

    /**
     * Metode que ens retorna el nom de la modalitat
     * @return Retorna el nom de la modalitat
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom de la modalitat
     * @param nom nom que s'intriduira en modalitat
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna la descripcio de modalitat
     * @return Retorna la descripcio de la modalitat
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripcó de modalitat
     * @param descripcio descripció que s'intriduira en modalitat
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
    
    
}
