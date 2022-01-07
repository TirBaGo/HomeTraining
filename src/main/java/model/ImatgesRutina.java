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

/**
 * Entitat per imatges_rutina
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name ="imatges_rutina")
public class ImatgesRutina implements Serializable{
    
    //Variables assocciades a la taula imatges rutina
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name= "id_imatge")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_imatge;
    
    @NotNull
    @Column(name = "id_rutina")
    private int  id_rutina;
    
    @Column(name = "imatge", nullable = true)
    private byte[] imatge;

    /**
     * Metode constructor per defecte
     */
    public ImatgesRutina() {
    }

    /**
     * Metode que ens retorna l'id d'imatges_rutina
     * @return Retorna l'id d'imatges_rutina
     */
    public int getId_imatge() {
        return id_imatge;
    }

    /**
     * Crea l'id per a imatges_rutina
     * @param id_imatge id que s'intriduira a imatges_rutina
     */
    public void setId_imatge(int id_imatge) {
        this.id_imatge = id_imatge;
    }

    /**
     * Metode que ens retorna l'id de la rutina assocciada a imatges_rutina
     * @return Retorna l'id de la rutina assocciada a imatges_rutina
     */
    public int getId_rutina() {
        return id_rutina;
    }

    /**
     * Crea l'id de la rutina assocciada a imatges_rutina
     * @param id_rutina id de la rutina assocciada que s'intriduira a imatges_rutina
     */
    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    /**
     * Metode que ens retorna l'imatge d'imatges_rutina
     * @return Retorna l'imatge d'imatges_rutina
     */
    public byte[] getImatge() {
        return imatge;
    }

    /**
     * Crea l'imatge a imatges_rutina
     * @param imatge imatge que s'introduira en imatges_rutina
     */
    public void setImatge(byte[] imatge) {
        this.imatge = imatge;
    }
 
}
