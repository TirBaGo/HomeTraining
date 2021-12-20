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
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
@Service
@Transactional
public class ImatgesRutinaServiceImp implements ImatgesRutinaService{
    
    @Autowired
    private ImatgesRutinaDAO imatgesRutinaDAO;

    @Transactional
    @Override
    public void crearImatgesRutina(ImatgesRutina imatgesRutina) {
        imatgesRutinaDAO.crearImatgesRutina(imatgesRutina);
    }

    @Transactional
    @Override
    public ImatgesRutina editarImatgesRutina(ImatgesRutina imatgesRutina) {
        return imatgesRutinaDAO.editarImatgesRutina(imatgesRutina);
    }

    @Transactional
    @Override
    public void eliminarImatgesRutina(ImatgesRutina imatgesRutina) {
        imatgesRutinaDAO.eliminarImatgesRutina(imatgesRutina);
    }

    @Override
    public List<ImatgesRutina> cercarTotesLesImatgesRutina() {
        return imatgesRutinaDAO.cercarTotesLesImatgesRutina();
    }

    @Override
    public ImatgesRutina cercarPerIdImatgesRutina(int id_imtage) {
        return imatgesRutinaDAO.cercarPerIdImatgesRutina(id_imtage);
    }

    @Override
    public List<ImatgesRutina> cercarPerIdRutina(int id_rutina) {
        return imatgesRutinaDAO.cercarPerIdRutina(id_rutina);
    }
    
}
