/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import es.uma.a6.service.I_pvtranslator.IPVTranslatorServer;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.pvtranslator.PVTranslatorServer;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author vikour
 */
@Named(value = "moduloFormBeans")
@RequestScoped
public class ModuloFormBeans {

    
    private IPVTranslatorServer server;

    @Inject private ConfigurationSessionBeans sesion;
    private boolean creationMode=true;
    
    private Modulo m;
    
    /**
     * Creates a new instance of ModuloFormBeans
     */
    public ModuloFormBeans() {
    }
    
    @PostConstruct
    public void init(){
        server=PVTranslatorServer.getInstance();
        
        m=sesion.getModulo();
        if(m!=null){
            creationMode=false;
        }else{
            m = new Modulo();
            creationMode=true;
        }
    }
    
    
    /*
        Getters y setters
    */

    public boolean isCreationMode() {
        return creationMode;
    }

    public Modulo getM() {
        return m;
    }

    public void setM(Modulo m) {
        this.m = m;
    }
    
    /*
        Método que, si no hay módulo seleccionado, creará uno nuevo y si hubiera uno seleccionado, lo modificará. 
    */
    
    public String doCrearEditar(){
        String next="";
        if(m.getKappa()>=0 && m.getAlpha()>=0 && m.getBeta()>=0 && m.getGamma()>=0 && !m.getNombre().equals("")){
            if(creationMode==false){                //se modifica el módulo
                server.editModulo(m);
                next="index.xhtml";
            }else if(server.findModulo(m.getNombre())==null){                                  //se crea un nuevo módulo
                server.createModulo(m);
                next="index.xhtml";
            }
        }else{
            next="moduloForm.xhtml";
        }
        return next;
    }
    
    public String atras(){
        return "index.xhtml";
    }
    
}