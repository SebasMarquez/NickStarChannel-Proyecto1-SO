/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author SebasBD
 */
public class Nickelodeon extends Thread{
    private Trabajador [] trabajadores;
    private int contadorPlotTwist;
    private int duracionDia;
    private int diasLanzamiento;
    private int contadorDias;
    private Semaphore semaforo = new Semaphore(1);
    private Drive drive;
    private ProjectManager pm;
    private boolean activo = true;
}
