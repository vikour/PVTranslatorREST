/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.I_pvtranslator;

import es.uma.a6.entitys.Modulo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IModuloOperation {
                
    List<Modulo> findAllOrderedByAlpha();
    
        
    List<Modulo> findAllOrderedByGamma();
    
    
    List<Modulo> findAllOrderedByBeta();
    
    
    List<Modulo> findAllOrderedByKappa();
    
    List<Modulo> findAllOrderedByName();
    
    
    List<Modulo> findAll();
    
    
    int count();

    Modulo find(String nombre);
    
    
    List<Modulo> findRange(int from, int to);
    
    
    void create(Modulo m);
    
    
    void edit(Modulo m);
    
    
    void remove(Modulo m);
    

}
