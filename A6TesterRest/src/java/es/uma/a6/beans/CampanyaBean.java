/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import WebService.Campaña;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Carlos
 */
@Named(value = "campanyaBean")
@RequestScoped
public class CampanyaBean {
    
    @Inject
    private SessionBean sesion;
    
    private List<Campaña> campanyas;

    /**
     * Creates a new instance of CampanyaBean
     */
    public CampanyaBean() {
    }
    
    @PostConstruct
    public void init(){
       campanyas=sesion.getListaCampanyas();
    }

    public List<Campaña> getCampanyas() {
        return campanyas;
    }
    
    public String doAtras(){
        return "index.xhtml";
    }
    
}
