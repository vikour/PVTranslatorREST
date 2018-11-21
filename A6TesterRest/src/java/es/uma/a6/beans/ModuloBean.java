/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import WebService.Modulo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Named(value = "moduloBean")
@RequestScoped
public class ModuloBean {
    
    @Inject
    private SessionBean sesion;
    
    private List<Modulo> modulos; 
    
    /**
     * Creates a new instance of ModuloBean
     */
    public ModuloBean() {
    }
    
    @PostConstruct
    public void init(){
        modulos = sesion.getListaModulos();
    }

    public List<Modulo> getModulos() {
        return modulos;
    }
    
    
    public String doAtras(){
        return "index.xhtml";
    }
    
    
}
