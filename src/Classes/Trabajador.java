/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import nickstarchannel.Main;

/**
 *
 * @author SebasBD
 */
public class Trabajador extends Thread{
    private int pagoTotal;
    private int dolarHora;
    private double produccionDiaria;
    private double produccionAcc;
    private boolean activo = true;
    private String parteProducida;
    private boolean ensamblador;
    private String empresa;
    
    
    
    public Trabajador(String tipo, String empresa){
        this.parteProducida = tipo;
        this.pagoTotal = 0;
        this.produccionAcc = 0;
        this.empresa = empresa;
        if(empresa.equals("nick")){
        this.inicializarTrabajadorPorTipoNick();
        }else if(empresa.equals("star")){
        this.inicializarTrabajadorPorTipoStarChannel();
        }
        
        
    
    }
    
    public void inicializarTrabajadorPorTipoNick(){
        if(this.parteProducida.equals("guion")){
            this.dolarHora = 20;
            this.produccionDiaria = 0.33;
        }else if(this.parteProducida.equals("diseño")){
            this.dolarHora = 26;
            this.produccionDiaria = 0.33;
        }else if(this.parteProducida.equals("animador")){
            this.dolarHora = 40;
            this.produccionDiaria = 2;
        }else if(this.parteProducida.equals("doblaje")){
            this.dolarHora = 16;
            this.produccionDiaria = 3;
        }else if(this.parteProducida.equals("twist")){
            this.dolarHora = 34;
            this.produccionDiaria = 0.33;
        }else if(this.parteProducida.equals("ensamblador")){
            this.dolarHora = 50;
            this.produccionDiaria = 0.5;
            this.ensamblador = true;
        }else{
            this.dolarHora = 0;
            this.produccionDiaria = 0;
        }
        
        setProduccionAcc(0);
        setEnsamblador(false);
    
    }
    
    
    public void inicializarTrabajadorPorTipoStarChannel(){
        if(this.parteProducida.equals("guion")){
            this.dolarHora = 20;
            this.produccionDiaria = 0.25;
        }else if(this.parteProducida.equals("diseño")){
            this.dolarHora = 26;
            this.produccionDiaria = 0.25;
        }else if(this.parteProducida.equals("animador")){
            this.dolarHora = 40;
            this.produccionDiaria = 1;
        }else if(this.parteProducida.equals("doblaje")){
            this.dolarHora = 16;
            this.produccionDiaria = 5;
        }else if(this.parteProducida.equals("twist")){
            this.dolarHora = 34;
            this.produccionDiaria = 0.5;
        }else if(this.parteProducida.equals("ensamblador")){
            this.dolarHora = 50;
            this.produccionDiaria = 0.5;
            this.ensamblador = true;
        }else{
            this.dolarHora = 0;
            this.produccionDiaria = 0;
        }
        
        setProduccionAcc(0);
        setEnsamblador(false);
    
    }
    
        
    
    public void pagarTrabajadorDia(){
        this.pagoTotal += getDolarHora() *24;
    }
    
    public void producirParteCapitulo(){
        this.produccionAcc += getProduccionDiaria();
    }
    
    public void agregarProduccionHoyNick(){
        if (getProduccionAcc() >= 1){
            int produccion = (int) Math.floor(getProduccionAcc());
            
            try{
                Main.nick.getSemaforo().acquire();// aqui poner el otro semaforo de
                Main.nick.getDrive().agregarProduccion(parteProducida, produccion, Main.nick.esElSiguienteCapituloPlotTwist());
                Main.nick.getSemaforo().release();
                
                setProduccionAcc(0);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void agregarProduccionHoyStar(){
        if (getProduccionAcc() >= 1){
            int produccion = (int) Math.floor(getProduccionAcc());
            
            try{
                Main.star.getSemaforo().acquire();// aqui poner el otro semaforo de
                Main.star.getDrive().agregarProduccion(parteProducida, produccion, Main.star.esElSiguienteCapituloPlotTwist());
                Main.star.getSemaforo().release();
                
                setProduccionAcc(0);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    
    public void run(){
        while(this.activo){
            try{
                producirParteCapitulo();
                agregarProduccionHoyNick();
                pagarTrabajadorDia();
                
                Thread.sleep(Main.nick.getDuracionDia());
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    }

    /**
     * @return the pagoTotal
     */
    public int getPagoTotal() {
        return pagoTotal;
    }

    /**
     * @param pagoTotal the pagoTotal to set
     */
    public void setPagoTotal(int pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    /**
     * @return the dolarHora
     */
    public int getDolarHora() {
        return dolarHora;
    }

    /**
     * @param dolarHora the dolarHora to set
     */
    public void setDolarHora(int dolarHora) {
        this.dolarHora = dolarHora;
    }

    /**
     * @return the produccionDiaria
     */
    public double getProduccionDiaria() {
        return produccionDiaria;
    }

    /**
     * @param produccionDiaria the produccionDiaria to set
     */
    public void setProduccionDiaria(int produccionDiaria) {
        this.produccionDiaria = produccionDiaria;
    }

    /**
     * @return the produccionAcc
     */
    public double getProduccionAcc() {
        return produccionAcc;
    }

    /**
     * @param produccionAcc the produccionAcc to set
     */
    public void setProduccionAcc(int produccionAcc) {
        this.produccionAcc = produccionAcc;
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
     * @return the parteProducida
     */
    public String getParteProducida() {
        return parteProducida;
    }

    /**
     * @param parteProducida the parteProducida to set
     */
    public void setParteProducida(String parteProducida) {
        this.parteProducida = parteProducida;
    }

    /**
     * @return the ensamblador
     */
    public boolean isEnsamblador() {
        return ensamblador;
    }

    /**
     * @param ensamblador the ensamblador to set
     */
    public void setEnsamblador(boolean ensamblador) {
        this.ensamblador = ensamblador;
    }
}
