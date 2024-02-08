/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import nickstarchannel.Main;

/**
 *
 * @author SebasBD
 */
public class Director extends Thread{
    private int pagoDia;
    private int pagoHora;
    private int pagoTotal;
    private String estadoDirector;
    private boolean activo = true;
    private int capitulosNormalesAcc;
    private int capitulosTwistAcc;
    private int diasLanzamiento;
    
    public Director(int diasLanzamiento){
        this.diasLanzamiento = diasLanzamiento;
        this.pagoTotal = 0;
        this.pagoDia = 0;
        this.pagoHora = 60;
    
    }
    
    @Override
    
    public void run(){
        while(this.activo){
            pagarDirectorDia();
            boolean reportarAEstudio = verContador();
            if(reportarAEstudio){
                // entregar caps
                lanzarCapitulos();
            }else{
                //trabajar normal
                trabajo();
            }
            
        }
    
    }
    public void  trabajo(){
        setEstadoDirector("Trabajando");
        Random random = new Random();
        int intervaloVerPm = (int) ((35/1440) * Main.nick.getDuracionDia());
        int comenzarVigilarPm = random.nextInt(24);
        int verPm = (int)((comenzarVigilarPm/24) * Main.nick.getDuracionDia()); //Cambiar el 1000 por la duracion del dia
        int dejarVerPm = verPm + intervaloVerPm;
        int restoDia = Main.nick.getDuracionDia() - dejarVerPm;
        try{
            //trabajando
            sleep(verPm);
            //Vigila al Pm
            setEstadoDirector("Vigilando PM");
            sleep(dejarVerPm);
            //Deja de ver al Pm y vuelve a trabajar
            setEstadoDirector("Trabajando");
            sleep(restoDia);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verContador(){
        try{
            Main.nick.getSemaforo().acquire();
            if(Main.nick.getPm().getDiasParaPublicar() <= 0){
                Main.nick.getPm().setDiasParaPublicar(diasLanzamiento);
                Main.nick.getSemaforo().release();
                return true;
            }
            Main.nick.getSemaforo().release();
            return false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void lanzarCapitulosAcc(){
        // Aqui va todo el odigo relacionado a la interfaz grafica
        
        
        //Aqui se setea lo acumulado en 0
        setCapitulosNormalesAcc(0);
        setCapitulosTwistAcc(0);
    }
    
    public void lanzarCapitulos(){
        try{
            setEstadoDirector("Entregando Capitulos");
            lanzarCapitulosAcc();
            sleep(Main.nick.getDuracionDia());
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void faltasPm(){
        Main.nick.getPm().setPagoTotal(Main.nick.getPm().getPagoTotal() - 100);
        Main.nick.getPm().setFaltas(Main.nick.getPm().getFaltas() + 1);
    }
    
    public void pagarDirectorDia(){
        setPagoTotal(getPagoTotal() + (getPagoHora() *24) );
    }
    /**
     * @return the pagoDia
     */
    public int getPagoDia() {
        return pagoDia;
    }

    /**
     * @param pagoDia the pagoDia to set
     */
    public void setPagoDia(int pagoDia) {
        this.pagoDia = pagoDia;
    }

    /**
     * @return the pagoHora
     */
    public int getPagoHora() {
        return pagoHora;
    }

    /**
     * @param pagoHora the pagoHora to set
     */
    public void setPagoHora(int pagoHora) {
        this.pagoHora = pagoHora;
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
     * @return the estadoDirector
     */
    public String getEstadoDirector() {
        return estadoDirector;
    }

    /**
     * @param estadoDirector the estadoDirector to set
     */
    public void setEstadoDirector(String estadoDirector) {
        this.estadoDirector = estadoDirector;
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
     * @return the capitulosNormalesAcc
     */
    public int getCapitulosNormalesAcc() {
        return capitulosNormalesAcc;
    }

    /**
     * @param capitulosNormalesAcc the capitulosNormalesAcc to set
     */
    public void setCapitulosNormalesAcc(int capitulosNormalesAcc) {
        this.capitulosNormalesAcc = capitulosNormalesAcc;
    }

    /**
     * @return the capitulosTwistAcc
     */
    public int getCapitulosTwistAcc() {
        return capitulosTwistAcc;
    }

    /**
     * @param capitulosTwistAcc the capitulosTwistAcc to set
     */
    public void setCapitulosTwistAcc(int capitulosTwistAcc) {
        this.capitulosTwistAcc = capitulosTwistAcc;
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
    
    
}
