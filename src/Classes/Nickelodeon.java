/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Director director;
    private int utilidad;
    private boolean activo = true;
    
    public Nickelodeon(int duracionDia, int diasLanzamiento){
        this.duracionDia = duracionDia;
        this.diasLanzamiento = diasLanzamiento;
        this.utilidad = 0;
        this.director = new Director(diasLanzamiento);
        this.pm = new ProjectManager(diasLanzamiento);
        String parametrosIniciales = "src\\assets\\parametrosInicialesNick.txt";
        ParteDrive[] partesDrive = FuncionesTXT.cargarParametrosInicialesEstudio(parametrosIniciales);
        this.drive = new Drive(partesDrive);
        int[] cantidadTrabajadores = this.inicializarTrabajadores(partesDrive);
        this.iniciarProduccion();
        //int[] cantidadTrabajadores = this.
    }
    
    @Override
    
    public void run (){
        while(this.activo){
            try{
                registrarUtilidadHoy();
                
                Thread.sleep(duracionDia);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nickelodeon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void iniciarTodosTrabajadores(){
        for(int i = 0; i < 15; i++){
            getTrabajador(i).start();
        }
    }
    
    public void iniciarProduccion(){
        iniciarTodosTrabajadores();
        getDirector().start();
        getPm().start();
    }
    public Trabajador getTrabajador(int i){
        return this.trabajadores[i];
    }
    
    public int [] inicializarTrabajadores(ParteDrive[] parteDrive){
        this.trabajadores = new Trabajador[15];
        int contador = 0;
        int[] cantidadTrabajadores= new int[6];
        int contadorTrabajador = 0;
        for (ParteDrive initialDriveInfo : parteDrive){
            for (int i = 0; i<initialDriveInfo.getCantidadTrabajadoresIniciales(); i++) {
                trabajadores[contador] = new Trabajador( (initialDriveInfo.getNombreParte()), "nick");
                contador++;
            }
            
            cantidadTrabajadores[contadorTrabajador] = initialDriveInfo.getCantidadTrabajadoresIniciales();
            contadorTrabajador++;
            
        }
        
        while (contador < 15){
            trabajadores[contador] = new Trabajador("","nick");
            contador++;
        }
        return cantidadTrabajadores;
        
    }
    public int getGananciaLanzamientoNick(){
        int capitulosNormales = getDirector().getCapitulosNormalesAcc();
        int capitulosTwist = getDirector().getCapitulosTwistAcc();
        int gananciaCapsNormales = 450;
        int gananciaCapsTwist = 500;
        int gananciaLanzamiento = (capitulosNormales * gananciaCapsNormales) + (capitulosTwist * gananciaCapsTwist);
        
        return gananciaLanzamiento;
    }
    
    public int getSalariosDiarios(){
        int total = 0;
        for(int i = 0; i<15; i++){
            total += getTrabajador(i).getPagoTotal();
        }
        
        total += getDirector().getPagoTotal();
        total += getPm().getPagoTotal();
        
        return total;
    }
    
    public void registrarUtilidadHoy(){
        this.setUtilidad(this.getUtilidad() + getGananciaLanzamientoNick() - getSalariosDiarios());
        this.contadorDias += 1;
        
    }
    
    public void nuevoCapituloCreado(){
        setContadorPlotTwist(getContadorPlotTwist()+1);
    }
    
    public boolean esElSiguienteCapituloPlotTwist(){
        return (getContadorPlotTwist() >= 5);
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

    /**
     * @return the utilidad
     */
    public int getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }
}
