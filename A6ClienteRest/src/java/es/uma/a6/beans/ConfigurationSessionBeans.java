/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;


import es.uma.a6.entitys.Modulo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;


/**
 *
 * @author vikour
 */
@Named(value = "configurationSessionBeans")
@SessionScoped
public class ConfigurationSessionBeans implements Serializable {

    private Modulo moduloSeleccionado;
    private String user;
    private String error;
    
    public ConfigurationSessionBeans() {
    }
    
    @PostConstruct
    public void init(){
        moduloSeleccionado=null;
        user="";
        
    }
    
    public Modulo getModulo(){
        return moduloSeleccionado;
    }
    
    public void setModulo(Modulo m){
        moduloSeleccionado=m;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
   public String goAplicacion(){
       System.out.println("email:"+user);
       if(user.equals("")){
           error="Debes iniciar sesión con la cuenta de Google";
           return "login.xhtml";
       }else{
           System.err.println(user);
           error="Puedes acceder a la aplicación";
            return "index.xhtml";
       }
      
      //return "index.xhtml";
   }
   
   public boolean isAdministrador(){
       boolean res=false;
       if(ProxyUsuario.ProxyUsuario.isAdmin(user)){
           res=true;
       }
       return res;
   }
    
    
    
}
