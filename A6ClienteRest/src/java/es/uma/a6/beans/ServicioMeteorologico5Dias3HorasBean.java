/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import es.uma.a6.entitys.Meteo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Rafa
 */
@Named(value = "servMeteo5Dias3HorasBean")
@SessionScoped
public class ServicioMeteorologico5Dias3HorasBean implements Serializable {

    static String apiKey = "07819c466ef342e6a4e5b9dbc8e7eb8e";
    static String weatherCity = "Malaga,es";
    static String units = "metric";
    private static final String BASE_URI = "https://api.openweathermap.org/data/2.5/forecast?q=" + weatherCity + "&units=" + units + "&appid=" + apiKey;
    private WebTarget webTarget;
    private Client client;
    private List<Meteo> listaMeteo;
    private int posicion = 0;
    private List<Meteo> listaMeteoDiv10;

    public ServicioMeteorologico5Dias3HorasBean() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
        listaMeteo = new ArrayList();
        listaMeteoDiv10 = new ArrayList();
        String datos = getTiempoEnVivoSinTratarDatos();
        try {
            String tiempo;
            double temperatura;
            double humedad;
            double velocidadViento;
            double direccionViento;
            double nubesActual;
            String fecha;

            JSONObject json = new JSONObject(datos);

            JSONArray ja = json.getJSONArray("list");
            JSONObject aux;
            JSONArray jaAux;
            JSONObject aux2;
            JSONObject main;
            JSONObject wind;
            JSONObject clouds;
            for (int i = 0; i < ja.length(); i++) {
                aux = ja.getJSONObject(i);

                //Tiempo actual//
                jaAux = aux.getJSONArray("weather");
                aux2 = jaAux.getJSONObject(0);
                tiempo = aux2.getString("description");
                
                //TemperaturaActual//
                main = aux.getJSONObject("main");
                temperatura = main.getDouble("temp");
                //HumedadActual//
                humedad = main.getDouble("humidity");
                
                //VelocidadVientoActual//
                wind = aux.getJSONObject("wind");
                velocidadViento = wind.getDouble("speed");

                //DireccionVientoActual//
                direccionViento = wind.getDouble("deg");
                
                //NubesActual//
                clouds = aux.getJSONObject("clouds");
                nubesActual = clouds.getDouble("all");
                
                //FechaActual//
                fecha = aux.getString("dt_txt");
                
                Meteo m = new Meteo(tiempo, temperatura, humedad, velocidadViento, direccionViento, nubesActual, fecha);
                listaMeteo.add(m);
            }
            listaMeteoDiv10 = crearListaMeteoDiv10();
        } catch (JSONException ex) {
            Logger.getLogger(ServicioMeteorologico5Dias3HorasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private <T> T getTiempoEnVivo(Class<T> responseType) {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getTiempoEnVivoSinTratarDatos() {
        Response r = getTiempoEnVivo(Response.class);
        GenericType<String> genericType = new GenericType<String>() {
        };
        return r.readEntity(genericType);
    }

    public List<Meteo> getListaMeteo() {
        return listaMeteo;
    }
    
    public List<Meteo> getListaMeteoDiv10() {
        return listaMeteoDiv10;
    }
    
    public List<Meteo> crearListaMeteoDiv10() {
        listaMeteoDiv10.clear();
        if(listaMeteo.size()<posicion*10+10){
            listaMeteoDiv10 = new ArrayList(listaMeteo.subList(posicion*10, listaMeteo.size()));
        }else{
            listaMeteoDiv10 = new ArrayList(listaMeteo.subList(posicion*10, posicion*10+10));
        }
        
        return listaMeteoDiv10;
    }
    
    public void next(){
        if(((posicion+1)*10)<listaMeteo.size()){
            posicion++;
        }
        crearListaMeteoDiv10();
    }
    
    public void back(){
        if(((posicion-1)*10)>=0){
            posicion--;
        }
        crearListaMeteoDiv10();
    }
    
    public boolean renderizarNext(){
        if(((posicion+1)*10)>=listaMeteo.size()){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean renderizarBack(){
        if(((posicion-1)*10)<0){
            return false;
        }else{
            return true;
        }
    }
    
    public String verTiempo(){
        return "verTiempo.xhtml";
    }
}
