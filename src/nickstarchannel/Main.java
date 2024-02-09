/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nickstarchannel;

import Classes.Director;
import Classes.Estudio;
import Classes.ProjectManager;
import Classes.Trabajador;

/**
 *
 * @author SebasBD
 */
public class Main {
    public static Estudio nick = new Estudio(1000, 5);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //ProjectManager pm = new ProjectManager(10);
        //pm.start();
       Director dm = new Director(5);
       dm.start();
    }
    
}
