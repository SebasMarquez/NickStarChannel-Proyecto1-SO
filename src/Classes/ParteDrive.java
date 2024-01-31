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
    
    
    public ParteDrive(int cantidadProducida, int capacidadMax, String nombreParte){
        this.cantidadProducida = cantidadProducida;
        this.capacidadMax = capacidadMax;
        this.nombreParte = nombreParte;
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
}
