/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.entitys;

/**
 *
 * @author Rafa
 */
public class Meteo {
    private final String tiempo;
    private final double temperatura;
    private final double humedad;
    private final double velocidadViento;
    private final double direccionViento;
    private final double nubesActual;
    private final String fecha;
    
    public Meteo(String tiempo, double temperatura, double humedad, double velocidadViento, double direccionViento, double nubesActual, String fecha){
        this.tiempo = tiempo;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.velocidadViento = velocidadViento;
        this.direccionViento = direccionViento;
        this.nubesActual = nubesActual;
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public double getVelocidadViento() {
        return velocidadViento;
    }

    public double getDireccionViento() {
        return direccionViento;
    }

    public double getNubesActual() {
        return nubesActual;
    }

    public String getFecha() {
        return fecha;
    }
}
