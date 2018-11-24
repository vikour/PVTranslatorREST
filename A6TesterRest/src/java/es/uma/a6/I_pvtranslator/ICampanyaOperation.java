/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.I_pvtranslator;

import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.Modulo;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface ICampanyaOperation {
    
    int count();

    Campanya find(String nombre, String modulo);
    
    
    List<Campanya> findRange(int from, int to);
    
    
    void create(Campanya m);
    
    
    void edit(Campanya m);
    
    
    void remove(Campanya m);
    
    List<Campanya> findAllOrderedByDateDesc();
    
    List<Campanya> findAllOrderedByDateAsc();
    
    List<Campanya> findAll();
    
    List<Campanya> findAllOrderedByName();
    
    List<Campanya> findByModulo(Modulo m);
}
