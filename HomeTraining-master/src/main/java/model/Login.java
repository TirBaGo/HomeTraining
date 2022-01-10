/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entitat per a la taula login
 * @author Nerea Gallardo
 * @version 2.0
 */
@Entity
@Table(name = "login")
public class Login implements Serializable{
    
    //Variables associades a la taula login
     private static final long serialVersionUID = 1L;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "username")
    @Id
    private String username;

    @NotNull
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "dni")
    private String dni;

    /**
     * Metode constructor per defecte
     */
    public Login() {
    }
    
    /**
     * Metode que ens retorna l'username per a login
     * @return Retorna l'username de login
     */
    public String getUsername() {
        return username;
    }

    /**
     * Crea l'username per a login
     * @param username username que s'introduira en login
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metode que ens retorna la contrasenya de login
     * @return Retorna la ocntrasenya de login
     */
    public String getPassword() {
        return password;
    }

    /**
     * Crea la contrasenya per a login
     * @param password password que s'introduira en login
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metode que ens retorna el dni assocciat a un usuari per a login
     * @return Retorna el dni assocciat a un usuari de login
     */
    public String getDni() {
        return dni;
    }

    /**
     * Crea el dni assocciat amb usuari per a login
     * @param dni dni que s'introduira en login
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
