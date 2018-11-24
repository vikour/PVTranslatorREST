/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import es.uma.a6.I_pvtranslator.IPVTranslatorServer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.pvtranslator.PVTranslatorServer;
import es.uma.a6.service.CampanyaRest;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author W10
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {

    @Inject
    private SessionBean sessionBean;
    
    private String nombreCampanya;
    
    private List<Modulo> modulos;
    
    private List<Campanya> campanyas;
    
    private String moduloSeleccionado;
    
    private String campanyaSeleccionada;
    
    private String nombreModulo;
    
    private IPVTranslatorServer server;
    

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }
    
    @PostConstruct
    public void init(){
        server = PVTranslatorServer.getInstance();
        
        nombreCampanya="";
        modulos=server.findAllModulo();
        campanyas=server.findAllCampanya();
        moduloSeleccionado="";
        campanyaSeleccionada="";
        nombreModulo="";
    }
    
    

    public String getCampanyaSeleccionada() {
        return campanyaSeleccionada;
    }

    public void setCampanyaSeleccionada(String campanyaSeleccionada) {
        this.campanyaSeleccionada = campanyaSeleccionada;
    }
    
    

    public List<Campanya> getCampanyas() {
        return campanyas;
    }

    public void setCampanyas(List<Campanya> campanyas) {
        this.campanyas = campanyas;
    }
    
    

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }
    
    

    public String getNombreCampanya() {
        return nombreCampanya;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public String getModuloSeleccionado() {
        return moduloSeleccionado;
    }

    public void setModuloSeleccionado(String moduloSeleccionado) {
        this.moduloSeleccionado = moduloSeleccionado;
    }

    
    
    public void setNombreCampanya(String nombreCampanya) {
        this.nombreCampanya = nombreCampanya;
    }
    
    
    
    public String doFindAllCampanyas(){
        sessionBean.setListaCampanyas(server.findAllCampanya());
        return "campanya.xhtml";
    }
    
    public String doFindAllCampanyaOrderedByDateAsc(){
        sessionBean.setListaCampanyas(server.findAllCampanyaOrderedByDateAsc());
        return "campanya.xhtml";
    }
    
    public String doFindAllCampanyaOrderedByDateDesc(){
        sessionBean.setListaCampanyas(server.findAllCampanyaOrderedByDateDesc());
        return "campanya.xhtml";
    }
    public String doFindAllCampanyaOrderedByName(){
        sessionBean.setListaCampanyas(server.findAllCampanyaOrderedByName());
        return "campanya.xhtml";
    }
    
    public String doFindAllModulo(){
        sessionBean.setListaModulos(server.findAllModulo());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByAlpha(){
        sessionBean.setListaModulos(server.findAllModuloOrderedByAlpha());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByBeta(){
        sessionBean.setListaModulos(server.findAllModuloOrderedByBeta());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByGamma(){
        sessionBean.setListaModulos(server.findAllModuloOrderedByGamma());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByKappa(){
        sessionBean.setListaModulos(server.findAllModuloOrderedByKappa());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByName(){
        sessionBean.setListaModulos(server.findAllModuloOrderedByName());
        return "modulo.xhtml";
    }
    
    public String doFindCampanya(){
        List<Campanya> lista= new ArrayList();
        lista.add(server.findCampanya(nombreCampanya, nombreModulo));
        sessionBean.setListaCampanyas(lista);
        return "campanya.xhtml";
    }
    
    public String doFindCampanyaByModulo(){
        Modulo m= server.findModulo(moduloSeleccionado);
        sessionBean.setListaCampanyas(server.findCampanyaByModulo(m));
        return "campanya.xhtml";
        
    }
    
    
    public String doFindModuloByNombre(){
        List<Modulo> lista= new ArrayList();
        lista.add(server.findModulo(nombreModulo));
        sessionBean.setListaModulos(lista);
        return "modulo.xhtml";
        
    }
    
}
