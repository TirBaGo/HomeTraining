/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ImatgesRutina;

/**
 * DAO ImatgesRutina
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface ImatgesRutinaDAO {

    /**
     * Crear imatges rutina
     * @param imatgesRutina que es vol crear
     */
    public void crearImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * Edita imatges rutina
     * @param imatgesRutina que es vol editar
     * @return Imatge editada
     */
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * ELimia imatge rutina
     * @param imatgesRutina que es vol eliminar
     */
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * Cerca totes les imatges rutina
     * @return totes les imatges rutina
     */
    public List<ImatgesRutina> cercarTotesLesImatgesRutina();

    /**
     * Cerca les imatges rutina pel su id
     * @param id_imtage de la imatge que es vol cercar
     * @return la imatge amb l'id indicat
     */
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage);

    /**
     * Cerca per l'id de la rutina
     * @param id_rutina que es cercar
     * @return totes les rutines assocciades amb aquest id
     */
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina);
    
}
