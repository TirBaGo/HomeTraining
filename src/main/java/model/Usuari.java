package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Entitat Usuari
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

    /**
     * Metode constructor per defecte
     */
    public Usuari() {
    }

    /**
     * MEtode que ens retorna el dni de l'usuari
     * @return dni usuari
     */
    public String getDNI() {
        return dni;
    }

    /**
     * Metode que crea el dni
     * @param dni dni que s'introduira en usuari
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }

    /**
     * Metode que ens retorna el nom de l'usuari
     * @return nom usuari
     */
    public String getNom() {
        return nom;
    }

    /**
     * Metode que crea el nom de l'usuari
     * @param nom que s'introduira en usuari
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode que ens retorna el primer cognom de l'usuari
     * @return primer cognom 
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * Metode que crea el primer cognom de l'usuari
     * @param cognom1 que s'introduira en usuari
     */
    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    /**
     * Metode que ens retorna el segon cognom de l'usuari
     * @return Segon cognom 
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * Metode que crea el segon cognom de l'usuari
     * @param cognom2 que s'introduira en usuari
     */
    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    /**
     * Metode que retorna el mail de l'usuari
     * @return el email de l'usuari
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metode que crea el mail de l'usuari
     * @param email que s'introduira en usuari 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metode que retorna el telefon de l'usuari
     * @return telefon de l'usuari
     */
    public int getTelefon() {
        return telefon;
    }

    /**
     * Metode que crea el telefon de l'usuari
     * @param telefon que s'introduira en l'usuari
     */
    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    /**
     * MEtode que retorna l'adreça de l'usuari
     * @return l'adreça de l'usuari
     */
    public String getAdreca() {
        return adreca;
    }

    /**
     * Metode que crea l'adreça de l'usuari
     * @param adreca que s'introduira en l'usuari
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Metode que retorna la provincia de l'usuari
     * @return la provincia de l'usuari
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Metode que crea la provincia de l'usuari
     * @param provincia que s'introduira en l'usuari
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Metode que retorna la poblacio de l'usuari
     * @return la població de l'usuari
     */
    public String getPoblacio() {
        return poblacio;
    }

    /**
     * MEtode que crea la poblacio de l'usuari
     * @param poblacio que s'introduira en l'usuari
     */
    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    /**
     * Metode que retorna si l'usuari es entrenador
     * @return true o false
     */
    public boolean isIsEntrenador() {
        return isEntrenador;
    }

    /**
     * Metode que crea si l'usuari es entrenador
     * @param isEntrenador que s'introduira en l'usuari (true o false)
     */
    public void setIsEntrenador(boolean isEntrenador) {
        this.isEntrenador = isEntrenador;
    }

    /**
     * MEtode que retorna la data d'alta de l'usuari
     * @return la data d'alta
     */
    public Timestamp getData_alta() {
        return data_alta;
    }

    /**
     * Metode que crea la data d'alta de l'usuari
     * @param data_alta que s'introduira en l'usuari
     */
    public void setData_alta(Timestamp data_alta) {
        this.data_alta = data_alta;
    }

    /**
     * Metode que retorna si l'usuari es actiu
     * @return true o false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Metode que crea si l'usuari es actiu
     * @param active que s'introduira en l'usuari (true o false)
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Metode que retorna l'id de l'usuari
     * @return l'id de l'usuari
     */
    public int getId_usuari() {
        return id_usuari;
    }

    /**
     * Metode que crea l'id de l'usuari
     * @param id_usuari que s'introduira en l'usuari
     */
    public void setId_usuari(int id_usuari) {
        this.id_usuari = id_usuari;
    }

}

