/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "modalitat")
public class Modalitat implements Serializable{
     private static final long serialVersionUID = 1L;
     
    @NotNull
    @Column(name = "codi_modalitat")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codi_modalitat;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;


    @NotNull
    @Size(max = 255)
    @Column(name = "descripcio")
    private String descripcio;

    public Modalitat() {
    }

    public Modalitat(int codi_modalitat, String nom, String descripcio) {
        this.codi_modalitat = codi_modalitat;
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public int getCodi_modalitat() {
        return codi_modalitat;
    }

    public void setCodi_modalitat(int codi_modalitat) {
        this.codi_modalitat = codi_modalitat;
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
