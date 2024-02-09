/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author SebasBD
 */
public class ParteDrive {
    private int cantidadProducida;
    private int capacidadMax;
    private String nombreParte;
    private int cantidadTrabajadoresIniciales;
    
    
    public ParteDrive( String nombreParte, int cantidadProducida, int capacidadMax, int cantidadTrabajadoresIniciales){
        this.cantidadProducida = cantidadProducida;
        this.capacidadMax = capacidadMax;
        this.nombreParte = nombreParte;
        this.cantidadTrabajadoresIniciales = cantidadTrabajadoresIniciales;
    }
    
    public boolean hayEspacioDisponible(){
        if(getCantidadProducida() <= getCapacidadMax()){
            return true;
        
        }else{
            return false;
        }
        
    }
    /**
     * @return the cantidadProducida
     */
    public int getCantidadProducida() {
        return cantidadProducida;
    }

    /**
     * @param cantidadProducida the cantidadProducida to set
     */
    public void setCantidadProducida(int cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    /**
     * @return the capacidadMax
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * @param capacidadMax the capacidadMax to set
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    /**
     * @return the nombreParte
     */
    public String getNombreParte() {
        return nombreParte;
    }

    /**
     * @param nombreParte the nombreParte to set
     */
    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }

    /**
     * @return the cantidadTrabajadoresIniciales
     */
    public int getCantidadTrabajadoresIniciales() {
        return cantidadTrabajadoresIniciales;
    }

    /**
     * @param cantidadTrabajadoresIniciales the cantidadTrabajadoresIniciales to set
     */
    public void setCantidadTrabajadoresIniciales(int cantidadTrabajadoresIniciales) {
        this.cantidadTrabajadoresIniciales = cantidadTrabajadoresIniciales;
    }
}
