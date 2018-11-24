/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.beans.importador;

import es.uma.a6.entitys.Campanya;
import es.uma.a6.entitys.CampanyaPK;
import es.uma.a6.entitys.Modulo;
import es.uma.a6.pvtranslator.PVTranslatorServer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class FormatoCampaña extends FormatoFichero{

    private boolean sobreescribir;

    @Override
    public Object leer(File file) throws IOException {
        BufferedReader br = null;
        Campanya campaña = null;
        
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-15"));
        campaña = leerInfoBasica(br);
        
        return campaña;
    }

    private String readNotEmptyLine(BufferedReader br) throws IOException {
        String aux = null;
        
        do {
            aux = br.readLine();
        } while (aux !=null && aux.isEmpty());
        
        return aux;
    }

    private String extractValue(String line) {
        line = line.trim();
        return line.split("\t")[1];
    }

    @Override
    public void escribir(File file, Object objeto) {
       // no se exporta
    }
    
    @Override
    public String getExtension() {
        return "xls";
    }

    private Campanya leerInfoBasica(BufferedReader br) throws IOException {
        String line;
        Modulo modulo = null;
        Campanya campaña = null;
        String value;

        line = readNotEmptyLine(br);
        
        if (!line.contains("Módulo"))
            throw new RuntimeException("Error de formato");
        
        value = extractValue(line);
        modulo = crearModuloSiNoExiste(value);

        // leer campaña
        line = readNotEmptyLine(br);
        value = extractValue(line);
        campaña = crearCampanyaSiNoExiste(value, modulo);
        
        return campaña;
    }
    
    private Campanya crearCampanyaSiNoExiste(String name, Modulo modulo) {
        Campanya campaña = null;
        
        campaña = PVTranslatorServer.getInstance().findCampanya(name, modulo.getNombre());
        
        if (campaña == null) {
            campaña = new Campanya();
            campaña.setCampanyaPK(new CampanyaPK(name, modulo.getNombre()));
            campaña.setModulo1(modulo);
            campaña.setFecha(new Date());
            
            
            PVTranslatorServer.getInstance().createCampanya(campaña);
        }
        
        return campaña;
    }
    
    private Modulo crearModuloSiNoExiste(String name) {
        Modulo modulo = null;
        
        modulo = PVTranslatorServer.getInstance().findModulo(name);
        
        if (modulo == null) {
            modulo = new Modulo();
            modulo.setNombre(name);
            PVTranslatorServer.getInstance().createModulo(modulo);
        }
        
        return modulo;
    }

}

