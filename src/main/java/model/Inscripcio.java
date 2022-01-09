/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Entitat Inscripció
 * @author Nerea Gallardo Tirado
 * @version 1.0
 */

@Entity
@Table(name="inscripcio")
public class Inscripcio implements Serializable{
    //Variables assocciades a la taula Accessori
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name="id_inscripcio")
    @Id
    private int id_inscripcio;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "dni_usuari")
    private String dni_usuari;
    
    @NotNull
    @Size(max = 255)
    @Column (name = "nom_rutina")
    private String nom_rutina;
    
    @NotNull
    @Column (name = "ispagat")
    private boolean ispagat;
    
    @NotNull
    @Column(name = "data_alta")
    private Timestamp data_alta;
    
    @Column(name = "data_fi")
    private Timestamp data_fi;

    
    /**
     * Metode constructor per defecte
     */
    public Inscripcio() {
    }

    /**
     * Metode que ens retorna l'id de l'inscripcio
     * @return l'id de l'inscripcio
     */
    public int getId_inscripcio() {
        return id_inscripcio;
    }

    /**
     * Metode que crea el id de l'inscripcio
     * @param id_inscripcio que s'introduira en inscripcio
     */
    public void setId_inscripcio(int id_inscripcio) {
        this.id_inscripcio = id_inscripcio;
    }

    /**
     * Metode que retorna el dni de l'usuari
     * @return el dni de l'usuari
     */
    public String getDni_usuari() {
        return dni_usuari;
    }

    /**
     * Metode que crea el dni de l'usuari en inscripcio
     * @param dni_usuari que s'introduira en inscripcio
     */
    public void setDni_usuari(String dni_usuari) {
        this.dni_usuari = dni_usuari;
    }

    /**
     * Metode que retorna el nom de la rutina
     * @return el nom de la rutina
     */
    public String getNom_rutina() {
        return nom_rutina;
    }

    /**
     * Metode que crea el nom de la rutina
     * @param nom_rutina que s'introduira en inscripcio
     */
    public void setNom_rutina(String nom_rutina) {
        this.nom_rutina = nom_rutina;
    }

    /**
     * Metode que retorna si s'ha pagat l'inscripcio
     * @return true o false 
     */
    public boolean isIspagat() {
        return ispagat;
    }

    /**
     * Metode que crea si s'ha pagat l'inscripcio
     * @param ispagat que s'introduira en inscripcio
     */
    public void setIspagat(boolean ispagat) {
        this.ispagat = ispagat;
    }

    /**
     * Metode que retorna la data d'alta
     * @return la data d'alta
     */
    public Timestamp getData_alta() {
        return data_alta;
    }

    /**
     * Metode que crea la data d'alta
     * @param data_alta que s'introduira en inscripcio
     */
    public void setData_alta(Timestamp data_alta) {
        this.data_alta = data_alta;
    }

    /**
     * Metode que retorna la data fi
     * @return la data fi
     */
    public Timestamp getData_fi() {
        return data_fi;
    }

    /**
     * Metode que crea la data fin
     * @param data_fi que s'introduira en inscripcio
     */
    public void setData_fi(Timestamp data_fi) {
        this.data_fi = data_fi;
    }

}
