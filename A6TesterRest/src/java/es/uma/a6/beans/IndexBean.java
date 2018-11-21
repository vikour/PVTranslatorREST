/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import WebService.Campaña;
import WebService.Modulo;
import WebService.WSPVTranslator_Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author W10
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSPV_Translator/WSPV_Translator.wsdl")
    private WSPVTranslator_Service service;
    @Inject
    private SessionBean sessionBean;
    
    private String nombreCampanya;
    
    private List<Modulo> modulos;
    
    private List<Campaña> campanyas;
    
    private String moduloSeleccionado;
    
    private String campanyaSeleccionada;
    
    private String nombreModulo;
    

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }
    
    @PostConstruct
    public void init(){
        nombreCampanya="";
        modulos=findAllModulo();
        campanyas=findAllCampanya();
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
    
    

    public List<Campaña> getCampanyas() {
        return campanyas;
    }

    public void setCampanyas(List<Campaña> campanyas) {
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
        sessionBean.setListaCampanyas(findAllCampanya());
        return "campanya.xhtml";
    }
    
    public String doFindAllCampanyaOrderedByDateAsc(){
        sessionBean.setListaCampanyas(findAllCampanyaOrderedByDateAsc());
        return "campanya.xhtml";
    }
    
    public String doFindAllCampanyaOrderedByDateDesc(){
        sessionBean.setListaCampanyas(findAllCampanyaOrderedByDateDesc());
        return "campanya.xhtml";
    }
    public String doFindAllCampanyaOrderedByName(){
        sessionBean.setListaCampanyas(findAllCampanyaOrderedByName());
        return "campanya.xhtml";
    }
    
    public String doFindAllModulo(){
        sessionBean.setListaModulos(findAllModulo());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByAlpha(){
        sessionBean.setListaModulos(findAllModuloOrderedByAlpha());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByBeta(){
        sessionBean.setListaModulos(findAllModuloOrderedByBeta());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByGamma(){
        sessionBean.setListaModulos(findAllModuloOrderedByGamma());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByKappa(){
        sessionBean.setListaModulos(findAllModuloOrderedByKappa());
        return "modulo.xhtml";
    }
    
    public String doFindAllModuloOrderedByName(){
        sessionBean.setListaModulos(findAllModuloOrderedByName());
        return "modulo.xhtml";
    }
    
    public String doFindCampanya(){
        List<Campaña> lista= new ArrayList();
        lista.add(findCampanya(nombreCampanya));
        sessionBean.setListaCampanyas(lista);
        return "campanya.xhtml";
    }
    
    public String doFindCampanyaByModulo(){
        Modulo m= findModuloByNombre(moduloSeleccionado);
         sessionBean.setListaCampanyas(findCampanyaByModulo(m));
         return "campanya.xhtml";
        
    }
    
    public String doFindModuloByNombre(){
        List<Modulo> lista= new ArrayList();
        lista.add(findModuloByNombre(nombreModulo));
        sessionBean.setListaModulos(lista);
        return "modulo.xhtml";
        
    }
    
    public String doFindModuloByCampanya(){
        Campaña c= findCampanya(campanyaSeleccionada);
        List<Modulo> lista= new ArrayList();
        lista.add(findModuloByCampaña(c));
        sessionBean.setListaModulos(lista);
        return "modulo.xhtml";
        
    }

    private java.util.List<WebService.Campaña> findAllCampanya() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllCampanya();
    }

    private java.util.List<WebService.Campaña> findAllCampanyaOrderedByDateAsc() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllCampanyaOrderedByDateAsc();
    }

    private java.util.List<WebService.Campaña> findAllCampanyaOrderedByDateDesc() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllCampanyaOrderedByDateDesc();
    }

    private java.util.List<WebService.Campaña> findAllCampanyaOrderedByName() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllCampanyaOrderedByName();
    }

    private java.util.List<WebService.Modulo> findAllModulo() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModulo();
    }

    private java.util.List<WebService.Modulo> findAllModuloOrderedByAlpha() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModuloOrderedByAlpha();
    }

    private java.util.List<WebService.Modulo> findAllModuloOrderedByBeta() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModuloOrderedByBeta();
    }

    private java.util.List<WebService.Modulo> findAllModuloOrderedByGamma() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModuloOrderedByGamma();
    }

    private java.util.List<WebService.Modulo> findAllModuloOrderedByKappa() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModuloOrderedByKappa();
    }

    private java.util.List<WebService.Modulo> findAllModuloOrderedByName() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findAllModuloOrderedByName();
    }

    private Campaña findCampanya(java.lang.Object id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findCampanya(id);
    }

    private java.util.List<WebService.Campaña> findCampanyaByModulo(WebService.Modulo m) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findCampanyaByModulo(m);
    }

    private Modulo findModulo(java.lang.Object id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findModulo(id);
    }

    private Modulo findModuloByCampaña(WebService.Campaña c) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findModuloByCampaña(c);
    }

    private Modulo findModuloByNombre(java.lang.String nombre) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.WSPVTranslator port = service.getWSPVTranslatorPort();
        return port.findModuloByNombre(nombre);
    }
    

    
    
    
    
    
}
