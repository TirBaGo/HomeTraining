/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ImatgesRutinaDAO;
import java.util.List;
import javax.transaction.Transactional;
import model.ImatgesRutina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Implementació de Imatges Rutina Service
 * @author Nerea Gallardo
 * @version 1.0
 * @inheritDoc ImatgesRutinaService
 */
@Service
@Transactional
public class ImatgesRutinaServiceImp implements ImatgesRutinaService{
    
    @Autowired
    private ImatgesRutinaDAO imatgesRutinaDAO;

    /**
     * Metode que crea la imatge rutina
     * @param imatgesRutina que es vol crear
     */
    @Transactional
    @Override
    public void crearImatgesRutina(ImatgesRutina imatgesRutina) {
        imatgesRutinaDAO.crearImatgesRutina(imatgesRutina);
    }

    /**
     * MEtode que edita les imatges rutina
     * @param imatgesRutina que es vol editar
     * @return imatge rutina ediatada
     */
    @Transactional
    @Override
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina) {
        return imatgesRutinaDAO.editarImatgesRutina(imatgesRutina);
    }

    /**
     * Metode que elimina l'imatge rutina
     * @param imatgesRutina que es vol eliminar
     */
    @Transactional
    @Override
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina) {
        imatgesRutinaDAO.eliminarImatgesRutina(imatgesRutina);
    }

    /**
     * Metode que cerca totes les imatges rutina
     * @return totes les imatges rutina
     */
    @Override
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        return imatgesRutinaDAO.cercarTotesLesImatgesRutina();
    }

    /**
     * Metode que cerca les imatges per la seva id
     * @param id_imtage que es vol cercar
     * @return l'imatge rutina amb l'id indicat
     */
    @Override
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage) {
        return imatgesRutinaDAO.cercarPerIdImatgesRutina(id_imtage);
    }

    /**
     * Metode que cerca les imatges rutina per l'id de la rutina assocciada
     * @param id_rutina que es vol cercar
     * @return les imatges rutina assocciades amb l'id indicat
     */
    @Override
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina) {
        return imatgesRutinaDAO.cercarPerIdRutina(id_rutina);
    }
    
}
