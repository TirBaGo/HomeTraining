/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ImatgesRutina;

/**
 * Service imatgesRutina
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface ImatgesRutinaService {

    /**
     * Crear imatges rutina
     * @param imatgesRutina que es vol crear
     */
    public void crearImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * Editar imatges rutina
     * @param imatgesRutina que es vol editar
     * @return imatge Rtuina editat
     */
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * Eliminar imatges rutina
     * @param imatgesRutina que es vol eliminar
     */
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina);

    /**
     * Cercar totes les imatges rutina 
     * @return totes les imatges rutina
     */
    public List<ImatgesRutina> cercarTotesLesImatgesRutina();

    /**
     * Cercar imatge rutina per id
     * @param id_imtage que es vol cercar
     * @return imatge rutina amb el id indicat
     */
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage);

    /** 
     * Cercar imatges rutina per id de rutina
     * @param id_rutina que es vol cercar
     * @return imatges rutina amb l'id de rutina indicat
     */
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina);
}
