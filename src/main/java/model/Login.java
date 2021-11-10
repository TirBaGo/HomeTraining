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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Entity
@Table(name = "login")
public class Login implements Serializable{
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

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
