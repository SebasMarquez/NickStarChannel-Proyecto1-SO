/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nickstarchannel;

import Classes.ProjectManager;

/**
 *
 * @author SebasBD
 */
public class NickStarChannel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProjectManager pm = new ProjectManager(10);
        pm.start();
    }
    
}
