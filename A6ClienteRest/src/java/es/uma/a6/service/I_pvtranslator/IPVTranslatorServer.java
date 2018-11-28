/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.service.I_pvtranslator;

import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public abstract class IPVTranslatorServer {
    
    protected static IPVTranslatorServer server = null;
    
    protected IModuloOperation modulo;
    protected ICampanyaOperation campanya;
    
    
    
/*
--------------------------------------------------------------------------------
----------------------------------- MODULO -------------------------------------
--------------------------------------------------------------------------------
*/
    abstract public List<Modulo> findAllModuloOrderedByAlpha();
    
    abstract public List<Modulo> findAllModuloOrderedByGamma();
    
    abstract public List<Modulo> findAllModuloOrderedByBeta();
    
    abstract public List<Modulo> findAllModuloOrderedByKappa();
    
    abstract public List<Modulo> findAllModuloOrderedByName();
    
    abstract public List<Modulo> findAllModulo();
    
    abstract public int countModulo();

    abstract public Modulo findModulo(String nombre);
    
    abstract public List<Modulo> findModuloByNombreCampaña(String c);
    
    abstract public List<Modulo> findModuloRange(int from, int to);
    
    abstract public void createModulo(Modulo m);
    
    abstract public void editModulo(Modulo m);   
    
    abstract public void removeModulo(Modulo m);
    
/*
--------------------------------------------------------------------------------
---------------------------------- Campanya ------------------------------------
--------------------------------------------------------------------------------
*/
    
    abstract public int countCampanya();

    abstract public Campanya findCampanya(String nombre, String modulo);
    
    abstract public List<Campanya> findCampanyaRange(int from, int to);
    
    abstract public void createCampanya(Campanya m);
    
    abstract public void editCampanya(Campanya m);
    
    abstract public void removeCampanya(Campanya m);
    
    abstract public List<Campanya> findAllCampanyaOrderedByDateDesc();
    
    abstract public List<Campanya> findAllCampanyaOrderedByDateAsc();
    
    abstract public List<Campanya> findAllCampanya();
    
    abstract public List<Campanya> findAllCampanyaOrderedByName();
   
    abstract public List<Campanya> findCampanyaByModulo(Modulo m);

}
