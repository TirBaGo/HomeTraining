package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Nerea Gallardo
 * @version 1.1
 */
@Entity
@Table(name = "usuari")
public class Usuari implements Serializable{
     private static final long serialVersionUID = 1L;
     
    @NotNull
    @Size(max = 9)
    @Column(name = "id_usuari")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuari;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "dni")
    private String dni;

   
    
    @NotNull
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "cognom1")
    private String cognom1;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "cognom2")
    private String cognom2;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    
    @NotNull
    @Column(name = "telefon")
    private int telefon;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "adreca")
    private String adreca;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "provincia")
    private String provincia;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "poblacio")
    private String poblacio;
    
    @NotNull
    @Column(name = "isentrenador")
    private boolean isEntrenador;
    
    @NotNull
    @Column(name = "data_alta")
    private Timestamp data_alta;
    
    @NotNull
    @Column(name = "active")
    private boolean active;



    public Usuari() {
    }

    

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public boolean isIsEntrenador() {
        return isEntrenador;
    }

    public void setIsEntrenador(boolean isEntrenador) {
        this.isEntrenador = isEntrenador;
    }

    public Timestamp getData_alta() {
        return data_alta;
    }

    public void setData_alta(Timestamp data_alta) {
        this.data_alta = data_alta;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
     public int getId_usuari() {
        return id_usuari;
    }

    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }

    

  
}

