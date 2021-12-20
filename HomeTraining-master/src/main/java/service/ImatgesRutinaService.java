/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ImatgesRutina;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface ImatgesRutinaService {
    public void crearImatgesRutina(ImatgesRutina imatgesRutina);
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina);
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina);
    public List<ImatgesRutina> cercarTotesLesImatgesRutina();
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage);
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina);
}
