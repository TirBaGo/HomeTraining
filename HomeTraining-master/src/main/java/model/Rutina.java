/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


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
 * @version 1.1
 */
@Entity
@Table(name = "rutina")
public class Rutina {
    @NotNull
    @Column(name= "id_rutina")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rutina;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "dni_entrenador")
    private String dni_entrenador;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nom_accessori")
    private String nom_accessori;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nom_modalitat")
    private String nom_modalitat;
    
    @NotNull
    @Column(name = "preu")
    private double preu;
    

    @NotNull
    @Column(name = "active")
    private boolean active;
    

    @Column(name = "video", nullable = true)
    private byte[] video;
    
    @NotNull
    @Column(name= "nivell")
    private int nivell;

    @NotNull
    @Column(name = "duracio")
    private int duracio;
    

    @NotNull
    @Size(max = 255)
    @Column(name = "descripcio", nullable = true)
    private String descripcio;

    public Rutina() {
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni_entrenador() {
        return dni_entrenador;
    }

    public void setDni_entrenador(String dni_entrenador) {
        this.dni_entrenador = dni_entrenador;
    }

    public String getNom_accessori() {
        return nom_accessori;
    }

    public void setNom_accessori(String nom_accessori) {
        this.nom_accessori = nom_accessori;
    }

    public String getNom_modalitat() {
        return nom_modalitat;
    }

    public void setNom_modalitat(String nom_modalitat) {
        this.nom_modalitat = nom_modalitat;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getDuracio() {
        return duracio;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
}
