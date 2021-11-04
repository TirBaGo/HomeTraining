/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuari;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public class UsuariController {
    private UsuariDAO usuariDAO;
    
    public UsuariController(UsuariDAO usuariDAO){
        this.usuariDAO = usuariDAO;
    }
    public Usuari getUsuari(String DNI){
        return usuariDAO.cercarUsuariPerDNI(DNI);
    }
    
}
