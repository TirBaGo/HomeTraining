/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "queixes")
public class Queixes {
    
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

    public Queixes() {
    }

    public int getId_queixes() {
        return id_queixes;
    }

    public void setId_queixes(int id_queixes) {
        this.id_queixes = id_queixes;
    }

    public String getDni_usuari() {
        return dni_usuari;
    }

    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
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
