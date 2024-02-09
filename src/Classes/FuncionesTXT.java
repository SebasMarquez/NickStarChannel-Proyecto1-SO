/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SebasBD
 */
public class FuncionesTXT {
    
    
    public static void guardarParametrosIniciales(int duracionDia, int diasLanzamiento){
        int duracionDiams = duracionDia * 1000;
        String path = "src\\assets\\parametrosIniciales.txt";
        String parametrosIniciales = (String.valueOf(duracionDiams)+","+String.valueOf(diasLanzamiento));
        
        try{
            PrintWriter pw = new PrintWriter(path);
            pw.print(parametrosIniciales);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
    
    
    }
    
    public static String cargarTextoDesdeFile(String direccion){
        String texto = "";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String lineaActual;
            while((lineaActual = bf.readLine()) != null){
                texto += (lineaActual+"\n");
            }
        } catch (Exception e) {
            texto = "";
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            
        }
        return texto;
    }
    
    public static int[] cargarParametrosIniciales(){
        String direccion = "src\\assets\\parametrosIniciales.txt";
        String data = cargarTextoDesdeFile(direccion);
        String [] split = data.split(",");
        int [] valores = new int [2];
        
        valores[0] = Integer.parseInt(split[0].replace("\n",""));
        valores[1] = Integer.parseInt(split[1].replace("\n",""));
        
        return valores;
    }
    
    public static ParteDrive [] cargarParametrosInicialesEstudio(String direccion){
        ParteDrive [] parametros = new ParteDrive[6];
        String data = cargarTextoDesdeFile(direccion);
        String [] split = data.split("\n");
        for(int i = 0; i < split.length; i++){
            String[] parteParametros = split[i].split(",");
            ParteDrive parteCompleta = new ParteDrive(parteParametros[0],Integer.parseInt(parteParametros[1]),Integer.parseInt(parteParametros[2]), Integer.parseInt(parteParametros[3]));
            parametros[i] = parteCompleta;
        }
        
        return parametros;
    
    }
}
