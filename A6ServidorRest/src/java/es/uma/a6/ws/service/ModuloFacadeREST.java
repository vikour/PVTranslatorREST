/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.ws.service;

import es.uma.a6.entitys.Modulo;
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

/**
 *
 * @author Carlos
 */
@Stateless
@Path("modulo")
public class ModuloFacadeREST extends AbstractFacade<Modulo> {

    @PersistenceContext(unitName = "A6ServidorRESTPU")
    private EntityManager em;

    public ModuloFacadeREST() {
        super(Modulo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Modulo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Modulo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Modulo find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public List<Modulo> findAllOrderedByName(){
        Query q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.nombre ASC");
        return q.getResultList();
    }
    
    @GET
    @Path("order/alpha")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAllOrderedByAlpha(){
        Query q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.alpha");
        return q.getResultList();
    }
    
    @GET
    @Path("order/beta")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAllOrderedByBeta(){
        Query q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.beta");
        return q.getResultList();
    }
    
    @GET
    @Path("order/kappa")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAllOrderedByKappa(){
        Query q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.kappa");
        return q.getResultList();
    }
    
    @GET
    @Path("order/gamma")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modulo> findAllOrderedByGamma(){
        Query q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.gamma");
        return q.getResultList();
    }
    
    
}
