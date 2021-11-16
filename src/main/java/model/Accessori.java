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
 *
 * @author Nerea Gallardo 
 * @version 1.0
 */
@Entity
@Table(name="accessori")
public class Accessori implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(name="nom")
    @Size(max=255)
    @Id
    private String nom;
    
    @NotNull
    @Column(name = "descripcio")
    @Size(max=255)
    private String descripcio;

    public Accessori() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}
