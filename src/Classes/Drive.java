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
    private int capituloNormalNick;
    private int capituloTwistNick;
    private int capituloNormalStarChannel;
    private int capituloTwistStarChannel;
    
    
    public Drive (ParteDrive[] parametrosActuales){
        this.seccionesDrive = parametrosActuales;
        this.capituloNormalNick = 0;
        this.capituloTwistNick = 0;
        this.capituloNormalStarChannel = 0;
        this.capituloTwistStarChannel = 0;
    
    }
    
    public boolean hayPartesParaCapituloNormalDisponibleNick(){
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
    
    public boolean hayPartesParaCapituloTwistDisponibleNick(){
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
                if(parteCapitulo.getCantidadProducida() <= 1){
                    proceder = false;
                    break;
                }
            }
        }
        return proceder;
    }
    
    
    public boolean hayPartesParaCapituloNormalDisponibleStarChannel(){
        boolean proceder = true;
        
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                if(parteCapitulo.getCantidadProducida() <= 1){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                if(parteCapitulo.getCantidadProducida() <= 2){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                if(parteCapitulo.getCantidadProducida() <= 5){
                    proceder = false;
                    break;
                }
            }
        }
        
        return proceder;
    }
    
    public boolean hayPartesParaCapituloTwistDisponibleStarChannel(){
        boolean proceder = true;
        
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                if(parteCapitulo.getCantidadProducida() <= 1){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                if(parteCapitulo.getCantidadProducida() <= 2){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                if(parteCapitulo.getCantidadProducida() <= 3){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                if(parteCapitulo.getCantidadProducida() <= 5){
                    proceder = false;
                    break;
                }
            }else if(parteCapitulo.getNombreParte().equals("twist")){
                if(parteCapitulo.getCantidadProducida() <= 4){
                    proceder = false;
                    break;
                }
            }
        }
        return proceder;
    }
    
    
    
    
    
    public void producirCapituloNormalNick(){
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
            
            this.capituloNormalNick ++;
        }
    }
    
    public void producirCapituloTwistNick(){
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
            
            this.capituloTwistNick ++;
        }
    }
    
    
    public void producirCapituloNormalStarChannel(){
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 2);
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 3);
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 6);
            }
            
            this.capituloNormalStarChannel ++;
        }
    }
    
    public void producirCapituloTwistStarChannel(){
        for(ParteDrive parteCapitulo : getSeccionesDrive()){
            if(parteCapitulo.getNombreParte().equals("guion")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 2);
            }else if(parteCapitulo.getNombreParte().equals("diseño")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 3);
            }else if(parteCapitulo.getNombreParte().equals("animador")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 4);
            }else if(parteCapitulo.getNombreParte().equals("doblaje")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 6);
            }else if(parteCapitulo.getNombreParte().equals("twist")){
                parteCapitulo.setCantidadProducida(parteCapitulo.getCantidadProducida() - 5);
            }
            
            this.capituloTwistStarChannel ++;
        }
    }
    
    
    
    
    
    
    public int getCantidadTotalCapitulosNick(){
        int totalCapsNick = this.capituloNormalNick + this.capituloTwistNick;
        return totalCapsNick;
    }
    
    
    public int getCantidadTotalCapitulosStarChannel(){
        int totalCapsStarChannel = this.capituloNormalStarChannel + this.capituloTwistStarChannel;
        return totalCapsStarChannel;
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
    public int getCapituloNormalNick() {
        return capituloNormalNick;
    }

    /**
     * @param capituloNormal the capituloNormal to set
     */
    public void setCapituloNormalNick(int capituloNormalNick) {
        this.capituloNormalNick = capituloNormalNick;
    }

    /**
     * @return the capituloTwist
     */
    public int getCapituloTwistNick() {
        return capituloTwistNick;
    }

    /**
     * @param capituloTwist the capituloTwist to set
     */
    public void setCapituloTwistNick(int capituloTwistNick) {
        this.capituloTwistNick = capituloTwistNick;
    }
    
    
    
    
    
    public int getCapituloNormalStarChannel() {
        return capituloNormalStarChannel;
    }

    /**
     * @param capituloNormal the capituloNormal to set
     */
    public void setCapituloNormalStarChannel(int capituloNormalStarChannel) {
        this.capituloNormalStarChannel = capituloNormalStarChannel;
    }

    /**
     * @return the capituloTwist
     */
    public int getCapituloTwistStarChannel() {
        return capituloTwistStarChannel;
    }

    /**
     * @param capituloTwist the capituloTwist to set
     */
    public void setCapituloTwistStarChannel(int capituloTwistStarChannel) {
        this.capituloTwistStarChannel = capituloTwistStarChannel;
    }
}
