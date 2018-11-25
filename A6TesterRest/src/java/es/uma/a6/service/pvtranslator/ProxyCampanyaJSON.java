/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.service.pvtranslator;

import es.uma.a6.service.I_pvtranslator.ICampanyaOperation;
import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.rest.CampanyaRest;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Carlos
 */
public class ProxyCampanyaJSON implements ICampanyaOperation{
    
    private static ProxyCampanyaJSON proxy = null;
    private CampanyaRest clientCampanya;

    public ProxyCampanyaJSON() {
    }
    
    public static ICampanyaOperation getInstace() {
        if(proxy==null){
            proxy= new ProxyCampanyaJSON();
        }
        
        return proxy;
    }

    @Override
    public int count() {
        clientCampanya = new CampanyaRest();
        String s = clientCampanya.countREST();
        int res;
        try{
            res = Integer.valueOf(s);
        }catch(NumberFormatException e){
            res=-1;
        }
        return res;
    }

    @Override
    public Campanya find(String nombre, String modulo) {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.find_JSON(Response.class, "Campanya;nombre="+nombre+";modulo="+modulo);
        
        Campanya c = null;
        if (r.getStatus() == 200) {
            GenericType<Campanya> genericType = new GenericType<Campanya>(){};
            c = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return c;
    }

    @Override
    public List<Campanya> findRange(int from, int to) {
        String f, t;
        f = String.valueOf(from);
        t = String.valueOf(to);
        
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findRange_JSON(Response.class, f, t);
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }

    @Override
    public void create(Campanya c) {
        clientCampanya = new CampanyaRest();
        clientCampanya.create_JSON(c);
        clientCampanya.close();
    }

    @Override
    public void edit(Campanya c) {
        clientCampanya = new CampanyaRest();
        clientCampanya.edit_JSON(c, "Campanya;nombre="+c.getCampanyaPK().getNombre()+";modulo="+c.getCampanyaPK().getModulo());
        clientCampanya.close();
    }

    @Override
    public void remove(Campanya c) {
        clientCampanya = new CampanyaRest();
        clientCampanya.remove("Campanya;nombre="+c.getCampanyaPK().getNombre()+";modulo="+c.getCampanyaPK().getModulo());
        clientCampanya.close();
    }

    @Override
    public List<Campanya> findAllOrderedByDateDesc() {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findAllOrderedByDateDesc_JSON(Response.class);
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }

    @Override
    public List<Campanya> findAllOrderedByDateAsc() {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findAllOrderedByDateAsc_JSON(Response.class);
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }

    @Override
    public List<Campanya> findAll() {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findAll_JSON(Response.class);
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }

    @Override
    public List<Campanya> findAllOrderedByName() {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findAllOrderedByName_JSON(Response.class);
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }

    @Override
    public List<Campanya> findByModulo(Modulo m) {
        clientCampanya = new CampanyaRest();
        Response r = clientCampanya.findByModulo_JSON(Response.class, m.getNombre());
        
        List<Campanya> lista = null;
        if (r.getStatus() == 200) {
            GenericType<List<Campanya>> genericType = new GenericType<List<Campanya>>(){};
            lista = r.readEntity(genericType); 
        }
        
        clientCampanya.close();
        return lista;
    }
    
}
