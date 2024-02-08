 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.concurrent.Semaphore;
import nickstarchannel.Main;

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
            
            this.capituloNormal ++;
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
            
            this.capituloTwist ++;
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
            
            this.capituloNormal ++;
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
            
            this.capituloTwist ++;
        }
    }
    
    public void agregarProduccion(String nombreParte, int produccion, boolean esCapituloTwist){
        if (nombreParte.equals("")) {
            return;
        }
        
        int contador = 0;
        
        for (ParteDrive seccion : getSeccionesDrive()) {
            if (seccion.getNombreParte().equals(nombreParte)) {
                if (seccion.hayEspacioDisponible()) {
                        // crear capitulo
                        if (esCapituloTwist) {
                            if (hayPartesParaCapituloTwistDisponibleNick()) {
                                producirCapituloTwistNick();
                                Main.nick.setContadorPlotTwist(0);
                                //int chapterQty = Integer.parseInt(GlobalUI.getMainPage().getRMDashBoard1().getTwistChapterQty().getText());
                                //GlobalUI.getMainPage().getRMDashBoard1().getTwistChapterQty().setText(String.valueOf(chapterQty + 1));
                                Main.nick.getDirector().agregarCapituloTwistNick();
                            }else{
                                // agregar nueva parte al drive
                                seccion.setCantidadProducida(seccion.getCantidadProducida() + produccion);
                            }
                        } else {
                            // normal chapter
                            if (hayPartesParaCapituloNormalDisponibleNick()) {
                                 producirCapituloNormalNick();
                                 //int chapterQty = Integer.parseInt(GlobalUI.getMainPage().getRMDashBoard1().getNormalChapterQty().getText());
                                 //GlobalUI.getMainPage().getRMDashBoard1().getNormalChapterQty().setText(String.valueOf(chapterQty + 1));
                                 Main.nick.nuevoCapituloCreado();
                                 Main.nick.getDirector().agregarCapituloNormalNick();
                            }else{
                                // agregar nueva parte al drive
                                
                                seccion.setCantidadProducida(seccion.getCantidadProducida() + produccion);
                            }
                        }
                        //getTotalChapters().setText(String.valueOf(section.getProducedQty()));
                        
                    //} else {
                        // add new part to drive
                        //section.setProducedQty(section.getProducedQty()+production);
                        //getUiDriveQtyLabels()[count].setText(String.valueOf(section.getProducedQty()));
                    //}
                      //  return;
                }
                return;
            }
            contador++;
        }
        System.out.println("no se encontró la sección: "+ nombreParte);
    }
    
    
    
    public void mostrarPartesDrive(){
        System.out.println("Partes Drive:\n");
        
        for(int i = 0; i < getSeccionesDrive().length; i++){
            System.out.println(i+". "+getSeccionesDrive()[i].getNombreParte() + "Producido: " + getSeccionesDrive()[i].getCantidadProducida() + "MAX: "+ getSeccionesDrive()[i].getCapacidadMax());
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
