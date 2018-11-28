/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import es.uma.a6.entitys.Campanya;

/**
 *
 * @author Carlos
 */
@Named(value = "campanyaBean")
@RequestScoped
public class CampanyaBean {
    
    @Inject
    private SessionBean sesion;
    
    private List<Campanya> campanyas;

    /**
     * Creates a new instance of CampanyaBean
     */
    public CampanyaBean() {
    }
    
    @PostConstruct
    public void init(){
       campanyas=sesion.getListaCampanyas();
    }

    public List<Campanya> getCampanyas() {
        return campanyas;
    }
    
    public String doAtras(){
        return "index.xhtml";
    }
    
}
