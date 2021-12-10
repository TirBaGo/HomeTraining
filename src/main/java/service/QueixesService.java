/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Queixes;

/**
 *
 * @author Nerea Gallardo
 * @version 1.0
 */
public interface QueixesService {
    public void crearQueixa (Queixes queixes);
    public Queixes editarQueixa(Queixes queixes);
    public void eliminarQueixa(Queixes queixes);
    public Queixes cercarQueixaPerNom(String nom);
    public List<Queixes> cercarQueixaPerDNIUsuari(String dni_usuari);
    public Queixes cercarQueixaPerIdQueixes(int id_queixes);
    public List<Queixes> cercarTotesLesQueixes();
}
