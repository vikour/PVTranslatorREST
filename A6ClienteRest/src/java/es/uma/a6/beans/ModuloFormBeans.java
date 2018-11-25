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
    boolean creationMode=true;
    
    private Modulo m;
    private String errorN;
    private String errorA;
    private String errorB;
    private String errorG;
    private String errorK;
    
    /**
     * Creates a new instance of ModuloFormBeans
     */
    public ModuloFormBeans() {
    }
    
    @PostConstruct
    public void init(){
        server=PVTranslatorServer.getInstance();
        
        errorN="";
        errorA="";
        errorB="";
        errorG="";
        errorK="";
        
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

    public Modulo getM() {
        return m;
    }

    public void setM(Modulo m) {
        this.m = m;
    }

    public String getErrorN() {
        return errorN;
    }

    public String getErrorA() {
        return errorA;
    }

    public String getErrorB() {
        return errorB;
    }

    public String getErrorG() {
        return errorG;
    }

    public String getErrorK() {
        return errorK;
    }
    
    /*
        Método que, si no hay módulo seleccionado, creará uno nuevo y si hubiera uno seleccionado, lo modificará. 
    */
    
    public void comprobarError(){
        if(m.getNombre().equals("")){
            errorN="Error: escriba un nombre para el módulo";
        }else if(server.findModulo(m.getNombre())!=null){
            errorN="Error: existe un módulo con ese nombre";
        }else{
            errorN="";
        }
    }
    
    public void comprobarA(){
        if(m.getAlpha()<0){
            errorA="Error: valor invalido para alpha";
        }else{
            errorA="";
        }
    }
    
    public void comprobarB(){
        if(m.getBeta()<0){
            errorB="Error: valor invalido para beta";
        }else{
            errorB="";
        }
    }
    
    public void comprobarG(){
        if(m.getGamma()<0){
            errorG="Error: valor invalido para gamma";
        }else{
            errorG="";
        }
    }
    
    public void comprobarK(){
        if(m.getKappa()<0){
            errorK="Error: valor invalido para kappa";
        }else{
            errorK="";
        }
    }
    
    
    
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