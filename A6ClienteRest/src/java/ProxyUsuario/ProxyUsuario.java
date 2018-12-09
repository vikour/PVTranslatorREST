/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProxyUsuario;

/**
 *
 * @author W10
 */
public class ProxyUsuario {
    
    private static String admins[]={"sergio.fernandez.campos@gmail.com","alberonda@gmail.com","vikour92@gmail.com",
    "carlos.gamero2197@gmail.com", "rlillo.815@gmail.com", "pruebaparaingweb@gmail.com"};
    
    public static boolean isAdmin(String correo){
        boolean res=false;
        int i=0;
        while(!res && i<admins.length ){
            if(admins[i].equalsIgnoreCase(correo)){
                res=true;
            }
            i++;
        }
        
        return res;
    }
    
}
