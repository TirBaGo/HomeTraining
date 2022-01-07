/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitat per a la taula rutina
 * @author Nerea Gallardo 
 * @version 1.1
 */
@Entity
@Table(name = "rutina")
public class Rutina implements Serializable{
    
    //Variables assocciades a la taula rutina
    
    private static final long serialVersionUID = 1L;
    
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

    /**
     * Metode constructor per defecte
     */
    public Rutina() {
    }

    /**
     * Metode que ens retorna l'id de la rutina
     * @return Retorna l'id de la rutina
     */
    public int getId_rutina() {
        return id_rutina;
    }

    /**
     * Crea l'id de la rutina
     * @param id_rutina id que s'intriduira en rutina
     */
    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    /**
     * Metode que ens retorna el nom de la rutina
     * @return Retorna el nom de la rutina
     */
    public String getNom() {
        return nom;
    }

    /**
     * Crea el nom de la rutina
     * @param nom nom que s'intriduira en rutina
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna el dni de l'entrenador de la rutina
     * @return Retorna el dni de l'entrenador de la rutina
     */
    public String getDni_entrenador() {
        return dni_entrenador;
    }

    /**
     * Crea el dni de l'entrenador que crea la rutina
     * @param dni_entrenador dni de l'entrenador que s'intriduira en rutina
     */
    public void setDni_entrenador(String dni_entrenador) {
        this.dni_entrenador = dni_entrenador;
    }

    /**
     * Metode que ens retorna el nom de l'accessori de la rutina
     * @return Retorna el nom de l'accessori de la rutina
     */
    public String getNom_accessori() {
        return nom_accessori;
    }

    /**
     * Crea el nom de l'accessori de la rutina
     * @param nom_accessori nom del accessori que s'intriduira en rutina
     */
    public void setNom_accessori(String nom_accessori) {
        this.nom_accessori = nom_accessori;
    }

    /**
     * Metode que ens retorna el nom de la modalitat de la rutina
     * @return Retorna el nom de la modalitat de la rutina
     */
    public String getNom_modalitat() {
        return nom_modalitat;
    }

    /**
     * Crea el nom de la modalitat de la rutina
     * @param nom_modalitat nom de la modalitat que s'intriduira en rutina
     */
    public void setNom_modalitat(String nom_modalitat) {
        this.nom_modalitat = nom_modalitat;
    }

    /**
     * Metode que ens retorna el preu de la rutina
     * @return Retorna el preu de la rutina
     */
    public double getPreu() {
        return preu;
    }

    /**
     * Crea el preu de la rutina
     * @param preu preu que s'intriduira en rutina
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }


    /**
     * Metode que ens retorna si es activa la rutina
     * @return Retorna si es activa la rutina
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Crea si es activa de la rutina
     * @param active true o false que s'intriduira en rutina
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Metode que ens retorna el video de la rutina
     * @return Retorna el video de la rutina
     */
    public byte[] getVideo() {
        return video;
    }

    /**
     * Crea el video de la rutina
     * @param video video que s'intriduira en rutina
     */
    public void setVideo(byte[] video) {
        this.video = video;
    }

    /**
     * Metode que ens retorna el nivell de la rutina
     * @return Retorna el nivell de la rutina
     */
    public int getNivell() {
        return nivell;
    }

    /**
     * Crea el nivell de la rutina
     * @param nivell nivell que s'intriduira en rutina
     */
    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    /**
     * Metode que ens retorna la duració de la rutina
     * @return Retorna la duració de la rutina
     */
    public int getDuracio() {
        return duracio;
    }

    /**
     * Crea la duració de la rutina
     * @param duracio duració que s'intriduira en rutina
     */
    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    /**
     * Metode que ens retorna la descricpió de la rutina
     * @return Retorna la descripció de la rutina
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Crea la descripció de la rutina
     * @param descripcio descricpió que s'intriduira en rutina
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
}
