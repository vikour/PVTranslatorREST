/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.pvtranslator;

import es.uma.a6.I_pvtranslator.IModuloOperation;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.ModuloRest;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Carlos
 */
public class ProxyModuloJSON implements IModuloOperation{
    
    private static ProxyModuloJSON proxy = null;
    private ModuloRest clientModulo;

    public ProxyModuloJSON() {
    }
    
    public static IModuloOperation getInstace() {
        if(proxy==null){
            proxy= new ProxyModuloJSON();
        }
        
        return proxy;
    }

    @Override
    public List<Modulo> findAllOrderedByAlpha() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAllOrderedByAlpha_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }


    @Override
    public List<Modulo> findAllOrderedByGamma() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAllOrderedByGamma_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }

    @Override
    public List<Modulo> findAllOrderedByBeta() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAllOrderedByBeta_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }


    @Override
    public List<Modulo> findAllOrderedByKappa() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAllOrderedByKappa_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }
    
    @Override
    public List<Modulo> findAllOrderedByName() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAllOrderedByName_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        clientModulo.close();
        return lista;
    }

    @Override
    public List<Modulo> findAll() {
        clientModulo = new ModuloRest();
        Response r = clientModulo.findAll_JSON(Response.class);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }

    @Override
    public int count() {
        clientModulo = new ModuloRest();
        String s = clientModulo.countREST();
        int res;
        try{
            res = Integer.valueOf(s);
        }catch(NumberFormatException e){
            res=-1;
        }
        return res;
    }

    @Override
    public Modulo find(String nombre) {
        clientModulo = new ModuloRest();
        Response r = clientModulo.find_JSON(Response.class, nombre);
        
        Modulo modulo = null;
        if (r.getStatus() == 200) {
            GenericType<Modulo> genericType = new GenericType<Modulo>(){};
            modulo = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return modulo;
    }

    @Override
    public List<Modulo> findRange(int from, int to) {
        String f, t;
        f= String.valueOf(from);
        t="0";
        
        clientModulo = new ModuloRest();
        Response r = clientModulo.findRange_JSON(Response.class, f, t);
        
        List<Modulo> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Modulo>> genericType = new GenericType<List<Modulo>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientModulo.close();
        return lista;
    }

    @Override
    public void create(Modulo m) {
        clientModulo = new ModuloRest();
        clientModulo.create_JSON(m);
        clientModulo.close();
    }

    @Override
    public void edit(Modulo m) {
        clientModulo = new ModuloRest();
        clientModulo.edit_JSON(m, m.getNombre());
        clientModulo.close();
    }

    @Override
    public void remove(Modulo m) {
        clientModulo = new ModuloRest();
        clientModulo.remove(m.getNombre());
        clientModulo.close();
    }
    
}
