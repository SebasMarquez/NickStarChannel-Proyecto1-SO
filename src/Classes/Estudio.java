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
public class Estudio extends Thread{
    private Trabajador [] trabajadores;
    private int contadorPlotTwist;
    private int duracionDia;
    private int diasLanzamiento;
    private int contadorDias;
    private Semaphore semaforo = new Semaphore(1);
    private Drive drive;
    private ProjectManager pm;
    private Director director;
    private boolean activo = true;
    
    public Estudio(int duracionDia, int diasLanzamiento){
        this.duracionDia = duracionDia;
        this.diasLanzamiento = diasLanzamiento;
        this.director = new Director(diasLanzamiento);
        this.pm = new ProjectManager(diasLanzamiento);
    }
    public void print(){
        getDirector().getEstadoDirector();
    }
    /**
     * @return the trabajadores
     */
    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }

    /**
     * @param trabajadores the trabajadores to set
     */
    public void setTrabajadores(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }

    /**
     * @return the contadorPlotTwist
     */
    public int getContadorPlotTwist() {
        return contadorPlotTwist;
    }

    /**
     * @param contadorPlotTwist the contadorPlotTwist to set
     */
    public void setContadorPlotTwist(int contadorPlotTwist) {
        this.contadorPlotTwist = contadorPlotTwist;
    }

    /**
     * @return the duracionDia
     */
    public int getDuracionDia() {
        return duracionDia;
    }

    /**
     * @param duracionDia the duracionDia to set
     */
    public void setDuracionDia(int duracionDia) {
        this.duracionDia = duracionDia;
    }

    /**
     * @return the diasLanzamiento
     */
    public int getDiasLanzamiento() {
        return diasLanzamiento;
    }

    /**
     * @param diasLanzamiento the diasLanzamiento to set
     */
    public void setDiasLanzamiento(int diasLanzamiento) {
        this.diasLanzamiento = diasLanzamiento;
    }

    /**
     * @return the contadorDias
     */
    public int getContadorDias() {
        return contadorDias;
    }

    /**
     * @param contadorDias the contadorDias to set
     */
    public void setContadorDias(int contadorDias) {
        this.contadorDias = contadorDias;
    }

    /**
     * @return the semaforo
     */
    public Semaphore getSemaforo() {
        return semaforo;
    }

    /**
     * @param semaforo the semaforo to set
     */
    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * @return the drive
     */
    public Drive getDrive() {
        return drive;
    }

    /**
     * @param drive the drive to set
     */
    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    /**
     * @return the pm
     */
    public ProjectManager getPm() {
        return pm;
    }

    /**
     * @param pm the pm to set
     */
    public void setPm(ProjectManager pm) {
        this.pm = pm;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the director
     */
    public Director getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(Director director) {
        this.director = director;
    }
}
