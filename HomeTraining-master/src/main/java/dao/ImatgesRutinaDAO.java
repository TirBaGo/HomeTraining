/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ImatgesRutina;

/**
 *
 * @author ngall
 */
public interface ImatgesRutinaDAO {
    public void crearImatgesRutina(ImatgesRutina imatgesRutina);
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina);
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina);
    public List<ImatgesRutina> cercarTotesLesImatgesRutina();
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage);
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina);
    
}
