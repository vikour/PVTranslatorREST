/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
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
@Named(value = "servicioMeteorologicoBean")
@RequestScoped
public class ServicioMeteorologicoBean {

    static String apiKey = "07819c466ef342e6a4e5b9dbc8e7eb8e";
    static String weatherCity = "Malaga,es";
    static int forecastDays = 1;
    static String units = "metric";
    private static final String BASE_URI = "https://api.openweathermap.org/data/2.5/weather?q=" + weatherCity + "&units=" + units + "&appid=" + apiKey;
    private WebTarget webTarget;
    private Client client;
    List<String> listaDatos;
    List<Double> listaDatosNumericos;
//htp://api.openweathermap.org/data/2.5/forecast/daily?q=Malaga,es&cnt=5&appid=07819c466ef342e6a4e5b9dbc8e7eb8et

    public ServicioMeteorologicoBean() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
        listaDatos = new ArrayList();
        listaDatosNumericos = new ArrayList();
        String datos = getTiempoEnVivoSinTratarDatos();
        try {
            //Ciudad
            JSONObject json = new JSONObject(datos);
            listaDatos.add(json.getString("name"));
            
            //TemperaturaActual//
            JSONObject main = json.getJSONObject("main");
            listaDatosNumericos.add(main.getDouble("temp"));
            
            //HumedadActual//
            listaDatosNumericos.add(main.getDouble("humidity"));
            
            //TiempoActual//
            JSONArray ja = json.getJSONArray("weather");
            JSONObject aux = ja.getJSONObject(0);
            listaDatos.add((String)aux.get("description"));
            
            //VelocidadVientoActual//
            JSONObject wind = json.getJSONObject("wind");
            listaDatosNumericos.add(wind.getDouble("speed"));

            //DireccionVientoActual//
            listaDatosNumericos.add(wind.getDouble("deg"));
            
            //%NubesActual//
            JSONObject clouds = json.getJSONObject("clouds");
            listaDatosNumericos.add(clouds.getDouble("all"));
        } catch (JSONException ex) {
            Logger.getLogger(ServicioMeteorologicoBean.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getCiudad() {
        return listaDatos.get(0);
    }
    
    public double getTemperatura() {
        return listaDatosNumericos.get(0);
    }
    
    public double getHumedad() {
        return listaDatosNumericos.get(1);
    }
    
    public String getTiempo() {
        return listaDatos.get(1);
    }
    
    public double getVelocidadViento() {
        return listaDatosNumericos.get(2);
    }
    
    public double getDireccionViento() {
        return listaDatosNumericos.get(3);
    }
    
    public double getNubesActual() {
        return listaDatosNumericos.get(4);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
