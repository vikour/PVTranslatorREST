/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.service.pvtranslator;

import es.uma.a6.service.I_pvtranslator.IPVTranslatorServer;
import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class PVTranslatorServer extends IPVTranslatorServer{
    
    public static IPVTranslatorServer getInstance(){
        if(server==null){
            server = new PVTranslatorServer();
        }
        return server;
    }
    
    private PVTranslatorServer() {
        modulo = ProxyModuloJSON.getInstace();
        campanya = ProxyCampanyaJSON.getInstace();
    }

    @Override
    public List<Modulo> findAllModuloOrderedByAlpha() {
        return modulo.findAllOrderedByAlpha();
    }

    @Override
    public List<Modulo> findAllModuloOrderedByGamma() {
        return modulo.findAllOrderedByGamma();
    }

    @Override
    public List<Modulo> findAllModuloOrderedByBeta() {
        return modulo.findAllOrderedByBeta();
    }

    @Override
    public List<Modulo> findAllModuloOrderedByKappa() {
        return modulo.findAllOrderedByKappa();
    }
    
    @Override
    public List<Modulo> findAllModuloOrderedByName() {
        return modulo.findAllOrderedByName();
    }

    @Override
    public List<Modulo> findAllModulo() {
        return modulo.findAll();
    }
    
    @Override
    public List<Modulo> findModuloByNombreCampaña(String c) {
        return modulo.findByNombreCampaña(c);
    }

    @Override
    public int countModulo() {
        return modulo.count();
    }

    @Override
    public Modulo findModulo(String nombre) {
        return modulo.find(nombre);
    }

    @Override
    public List<Modulo> findModuloRange(int from, int to) {
        return modulo.findRange(from, to);
    }

    @Override
    public void createModulo(Modulo m) {
        modulo.create(m);
    }

    @Override
    public void editModulo(Modulo m) {
        modulo.edit(m);
    }

    @Override
    public void removeModulo(Modulo m) {
        modulo.remove(m);
    }

    @Override
    public int countCampanya() {
        return campanya.count();
    }

    @Override
    public Campanya findCampanya(String nombre, String modulo) {
        return campanya.find(nombre, modulo);
    }

    @Override
    public List<Campanya> findCampanyaRange(int from, int to) {
        return campanya.findRange(from, to);
    }

    @Override
    public void createCampanya(Campanya m) {
        campanya.create(m);
    }

    @Override
    public void editCampanya(Campanya m) {
        campanya.edit(m);
    }

    @Override
    public void removeCampanya(Campanya m) {
        campanya.remove(m);
    }

    @Override
    public List<Campanya> findAllCampanyaOrderedByDateDesc() {
        return campanya.findAllOrderedByDateDesc();
    }

    @Override
    public List<Campanya> findAllCampanyaOrderedByDateAsc() {
        return campanya.findAllOrderedByDateAsc();
    }

    @Override
    public List<Campanya> findAllCampanya() {
        return campanya.findAll();
    }

    @Override
    public List<Campanya> findAllCampanyaOrderedByName() {
        return campanya.findAllOrderedByName();
    }

    @Override
    public List<Campanya> findCampanyaByModulo(Modulo m) {
        return campanya.findByModulo(m);
    }

    
    
}
