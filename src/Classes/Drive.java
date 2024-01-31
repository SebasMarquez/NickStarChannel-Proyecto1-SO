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
public class Drive {
    private ParteDrive [] seccionesDrive;
    private Semaphore driveSemaphore = new Semaphore(1);
    private int capituloNormal;
    private int capituloTwist;
    
    
    public Drive (ParteDrive[] parametrosActuales){
        this.seccionesDrive = parametrosActuales;
        this.capituloNormal = 0;
        this.capituloTwist = 0;
    
    }
    
    public boolean hayPartesParaCapituloNormalDisponible(){
        boolean proceder = true;
        
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                if(parteCapitulo.getCantidadProducida() <= 1){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                if(parteCapitulo.getCantidadProducida() <= 0){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }
        }
        
        return proceder;
    }
    
    public boolean hayPartesParaCapituloTwistDisponible(){
        boolean proceder = true;
        
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                if(parteCapitulo.getCantidadProducida() <= 1){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                if(parteCapitulo.getCantidadProducida() <= 0){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("twist")){
                if(parteCapitulo.getCantidadProducida() <= 0){
                    proceder = false;
                    break;
                }
            }
        }
        return proceder;
    }
    
    public void producirCapituloNormal(){
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 2);
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 1);
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }
            
            this.capituloNormal ++;
        }
    }
    
    public void producirCapituloTwist(){
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 2);
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 1);
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }else if(parteCapitulo.getNombreParte().equals("twist")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 2);
            }
            
            this.capituloTwist ++;
        }
    }
    
    public int getCantidadTotalCapitulos(){
        int totalCaps = this.capituloNormal + this.capituloTwist;
        return totalCaps;
    }

    /**
     * @return the seccionesDrive
     */
    public ParteDrive[] getSeccionesDrive() {
        return seccionesDrive;
    }

    /**
     * @param seccionesDrive the seccionesDrive to set
     */
    public void setSeccionesDrive(ParteDrive[] seccionesDrive) {
        this.seccionesDrive = seccionesDrive;
    }

    /**
     * @return the driveSemaphore
     */
    public Semaphore getDriveSemaphore() {
        return driveSemaphore;
    }

    /**
     * @param driveSemaphore the driveSemaphore to set
     */
    public void setDriveSemaphore(Semaphore driveSemaphore) {
        this.driveSemaphore = driveSemaphore;
    }

    /**
     * @return the capituloNormal
     */
    public int getCapituloNormal() {
        return capituloNormal;
    }

    /**
     * @param capituloNormal the capituloNormal to set
     */
    public void setCapituloNormal(int capituloNormal) {
        this.capituloNormal = capituloNormal;
    }

    /**
     * @return the capituloTwist
     */
    public int getCapituloTwist() {
        return capituloTwist;
    }

    /**
     * @param capituloTwist the capituloTwist to set
     */
    public void setCapituloTwist(int capituloTwist) {
        this.capituloTwist = capituloTwist;
    }
    
    
}
