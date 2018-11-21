/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.ws.service;

import es.uma.a6.ws.Campanya;
import es.uma.a6.ws.CampanyaPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Carlos
 */
@Stateless
@Path("campanya")
public class CampanyaFacadeREST extends AbstractFacade<Campanya> {

    @PersistenceContext(unitName = "A6ServidorRESTPU")
    private EntityManager em;

    private CampanyaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;nombre=nombreValue;modulo=moduloValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        es.uma.a6.ws.CampanyaPK key = new es.uma.a6.ws.CampanyaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> nombre = map.get("nombre");
        if (nombre != null && !nombre.isEmpty()) {
            key.setNombre(nombre.get(0));
        }
        java.util.List<String> modulo = map.get("modulo");
        if (modulo != null && !modulo.isEmpty()) {
            key.setModulo(modulo.get(0));
        }
        return key;
    }

    public CampanyaFacadeREST() {
        super(Campanya.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Campanya entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Campanya entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        es.uma.a6.ws.CampanyaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Campanya find(@PathParam("id") PathSegment id) {
        es.uma.a6.ws.CampanyaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

/*
--------------------------------------------------------------------------------
------------------------------our operations------------------------------------
--------------------------------------------------------------------------------
*/
  
    @GET
    @Path("order/name")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findAllOrderedByName(){
        Query q = em.createQuery("SELECT c FROM Campanya c ORDER BY c.nombre ASC");
        return q.getResultList();
    }
    
    @GET
    @Path("order/date/asc")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findAllOrderedByDateAsc(){
        Query q = em.createQuery("SELECT c FROM Campanya c ORDER BY c.fecha ASC");
        return q.getResultList();
    }
    
    @GET
    @Path("order/date/dec")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findAllOrderedByDateDesc(){
        Query q = em.createQuery("SELECT c FROM Campanya c ORDER BY c.fecha DESC");
        return q.getResultList();
    }
    
    @GET
    @Path("modulo/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Campanya> findByModulo(String nombreModulo){
        Query q = em.createQuery("SELECT c FROM Campanya c WHERE :n = c.modulo1.nombre");
        q.setParameter("n", nombreModulo);
        return q.getResultList();
    }
    
}
