/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;


import es.uma.a6.I_pvtranslator.IPVTranslatorServer;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.pvtranslator.PVTranslatorServer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author vikour
 */
@Named(value = "homeBeans")
@RequestScoped
public class HomeBeans {

    private IPVTranslatorServer server;

    @Inject ConfigurationSessionBeans config;
    
    private List<Modulo> modulos;
    
    private Modulo moduloSeleccionado;
    
    

    /**
     * Creates a new instance of HomeBeans
     */
    
    public HomeBeans() {
    }
    /*
    @PostConstruct
    public void init(){
       modulos=this.findAllModulo();
        moduloSeleccionado=null;
    }*/

    @PostConstruct
    public void initialize() {
        server = PVTranslatorServer.getInstance();
        config.setModulo(null);
        modulos = server.findAllModulo();

    }
    
    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Modulo getModuloSeleccionado() {
        return moduloSeleccionado;
    }

    public void setModuloSeleccionado(Modulo moduloSeleccionado) {
        this.moduloSeleccionado = moduloSeleccionado;
    }
    
    public void doBorrar(Modulo m){
        
        server.removeModulo(m);
        modulos=server.findAllModulo();
        //return "index.xhtml";
        
    }
    
    
    public String doEditar(Modulo m){
        config.setModulo(m);
        return "moduloForm.xhtml";
        
    }
    
    public String doNew(){
        config.setModulo(null);
        return "moduloForm.xhtml";
        
    }
    
    public String goCampanya(Modulo m){
        config.setModulo(m);
        return "campanyas.xhtml";
    }


}
