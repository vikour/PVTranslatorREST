/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;


import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


/**
 *
 * @author Carlos
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    private List<Campanya> listaCampanyas;
    private List<Modulo> listaModulos;

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }

    @PostConstruct
    public void init(){
        listaCampanyas= new ArrayList<>();
        listaModulos= new ArrayList<>();
    }
    public List<Campanya> getListaCampanyas() {
        return listaCampanyas;
    }

    public void setListaCampanyas(List<Campanya> listaCampanyas) {
        this.listaCampanyas = listaCampanyas;
    }

    public List<Modulo> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(List<Modulo> listaModulos) {
        this.listaModulos = listaModulos;
    }
    
    
    
    
    
}
