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
public class ProjectManager extends Thread {
    private int diasParaPublicar;
    private int dolarPorHora;
    private int pagoTotal;
    private String pmEstado;
    private int faltas;
    private boolean activo = true;
    private Semaphore counterMutex = new Semaphore(1);
    
    
    public ProjectManager(int diasParaPublicar){
        this.diasParaPublicar = diasParaPublicar;
        this.faltas = 0;
        this.dolarPorHora = 40;
        this.pagoTotal = 0;
    
    }
    
    public void pagoDiarioPM(){
        setPagoTotal(getPagoTotal() + getDolarPorHora() * 24);
        
    }
    
    public void actualizarContador(){
        try{
            setPmEstado("cambiando contador");
            counterMutex.acquire();
            setPmEstado("cambiando contador");
            sleep(1000/3); // 8 hours
            setDiasParaPublicar(getDiasParaPublicar()-1);
            String newValue = (String.valueOf(getDiasParaPublicar())+" días");
            
            counterMutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void restoDia(){
        boolean trabajando = true;
        
        for(int i = 0; i < 32; i++){
            if(trabajando){
                setPmEstado("Trabajando");
            }else{
                setPmEstado("Viendo anime");
                if(Main.nick.getDirector().getEstadoDirector().equals("Vigilando PM")){
                    Main.nick.getDirector().faltasPm();
                }
            }
            
            trabajando = !trabajando;
            try{
                sleep(1000/480);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    @Override
    public void run(){
        while(this.activo){
            pagoDiarioPM();
            actualizarContador();
            restoDia();
            
        
        }
    }

    /**
     * @return the diasParaPublicar
     */
    public int getDiasParaPublicar() {
        return diasParaPublicar;
    }

    /**
     * @return the dolarPorHora
     */
    public int getDolarPorHora() {
        return dolarPorHora;
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
     * @return the pmEstado
     */
    public String getPmEstado() {
        return pmEstado;
    }

    /**
     * @param pmEstado the pmEstado to set
     */
    public void setPmEstado(String pmEstado) {
        this.pmEstado = pmEstado;
    }

    /**
     * @return the faltas
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    /**
     * @param diasParaPublicar the diasParaPublicar to set
     */
    public void setDiasParaPublicar(int diasParaPublicar) {
        this.diasParaPublicar = diasParaPublicar;
    }
    
    
    
    
}
