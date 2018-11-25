/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans.importador;

import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.pvtranslator.PVTranslatorServer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Vikour
 */
public class FormatoModulo extends FormatoFichero {
    
    private String nombre;
    private String tecnologia;
    private boolean sobreescribir;

    @Override
    public Object leer(File file) throws IOException {
        BufferedReader br = null;
        Modulo m = null;
        sobreescribir = true;

        br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-15"));
        m = construirMod(br);

        // comunicación con server.
        Modulo mserver = PVTranslatorServer.getInstance().findModulo(m.getNombre());
        if (mserver != null) {
            PVTranslatorServer.getInstance().editModulo(m);
        } else {
            PVTranslatorServer.getInstance().createModulo(m);
        }

        return m;
    }
    
    private String readNotEmptyLine(BufferedReader br) throws IOException {
        String aux = null;
        
        do {
            aux = br.readLine();
        } while (aux !=null && aux.isEmpty());
        
        return aux;
    }
    
    
    private Modulo construirMod(BufferedReader br) throws IOException{
        nombre=readNotEmptyLine(br);
        tecnologia=readNotEmptyLine(br);
        Modulo mod = new Modulo();
        
        mod.setNombre(nombre);
        filetoMod(br, mod);
        
        return mod;
    }
    
    private void filetoMod(BufferedReader br,Modulo mod) throws IOException{
        
            Double.parseDouble(readNotEmptyLine(br) );
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Integer.parseInt(readNotEmptyLine(br));
            Integer.parseInt(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            mod.setAlpha(Double.parseDouble(readNotEmptyLine(br)));
            mod.setBeta(Double.parseDouble(readNotEmptyLine(br)));
            mod.setGamma(Double.parseDouble(readNotEmptyLine(br)));
            mod.setKappa(Double.parseDouble(readNotEmptyLine(br)));/*
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            Double.parseDouble(readNotEmptyLine(br));
            String x=readNotEmptyLine(br);*/
    }
   
    @Override
    public void escribir(File file, Object objeto){
       // No se exporta
    }

    @Override
    public String getExtension() {
        return "dat"; 
    }
    
}
