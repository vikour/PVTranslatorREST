/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;


import es.uma.a6.service.I_pvtranslator.IPVTranslatorServer;
import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.pvtranslator.PVTranslatorServer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author vikour
 */
@Named(value = "campanyasBeans")
@RequestScoped
public class CampanyasBeans {

    
    @Inject
    private ConfigurationSessionBeans sesion;
    
    private IPVTranslatorServer server;
    
    private Modulo modulo;
    private List<Campanya> campañas;
    
    public CampanyasBeans() {
    }
    
    @PostConstruct
    public void init(){
        server=PVTranslatorServer.getInstance();
        
        modulo = sesion.getModulo();
        campañas= server.findCampanyaByModulo(modulo);
        
    }

    public Modulo getModulo() {
        return modulo;
    }

    public List<Campanya> getCampañas() {
        return campañas;
    }
    
    public void doRemove(Campanya c){
        campañas.remove(c);
        server.removeCampanya(c);        
    }
    
    public String doAtras(){
        return "index.xhtml";
    }
    
    public String doVer(Campanya c){
        // Not Implemented yet
        return null;
    }
    
   
}
