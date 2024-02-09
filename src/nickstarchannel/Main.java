/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nickstarchannel;

import Classes.Director;
import Classes.Nickelodeon;
import Classes.FuncionesTXT;
import Classes.ProjectManager;
import Classes.StarChannel;
import Classes.Trabajador;

/**
 *
 * @author SebasBD
 */
public class Main {
    public static Nickelodeon nick = new Nickelodeon(1000, 5);
    public static StarChannel star = new StarChannel(1000, 5);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Trabajador tbnick1 = new Trabajador("guion","nick");
        Trabajador tbnick2 = new Trabajador("diseño","nick");
        Trabajador tbnick3 = new Trabajador("animador","nick");
        Trabajador tbnick4 = new Trabajador("doblaje","nick");
        Trabajador tbnick5 = new Trabajador("twist","nick");
        Trabajador tbnick6 = new Trabajador("ensamblador","nick");
        tbnick1.start();
        tbnick2.start();
        tbnick3.start();
        tbnick4.start();
        tbnick5.start();
        tbnick6.start();
        
        System.out.println(nick.getPm().getPmEstado());
        System.out.println(nick.getDirector().getEstadoDirector());
        
        //ProjectManager pm = new ProjectManager(10);
        //pm.start();
       //Director dm = new Director(5);
       //dm.start();
       //FuncionesTXT.guardarParametrosIniciales(1, 6);
       //int[] valores = FuncionesTXT.cargarParametrosIniciales();
       // System.out.println(valores[0]+","+valores[1]);
    }
    
}
