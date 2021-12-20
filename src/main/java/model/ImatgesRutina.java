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

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name ="imatges_rutina")
public class ImatgesRutina {
    
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

    public ImatgesRutina() {
    }

    public int getId_imatge() {
        return id_imatge;
    }

    public void setId_imatge(int id_imatge) {
        this.id_imatge = id_imatge;
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public byte[] getImatge() {
        return imatge;
    }

    public void setImatge(byte[] imatge) {
        this.imatge = imatge;
    }
    
    
    
}
