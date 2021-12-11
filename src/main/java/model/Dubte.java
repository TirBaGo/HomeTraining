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
@Table(name = "dubte")
public class Dubte {
    
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

    public Dubte() {
    }

    public int getId_dubte() {
        return id_dubte;
    }

    public void setId_dubte(int id_dubte) {
        this.id_dubte = id_dubte;
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
