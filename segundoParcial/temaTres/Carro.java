/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.segundoParcial.temaTres;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Carro {
    private Semaphore asientos; //representa los asientos del carro
    private Semaphore puedeArrancar; //para avisarle a la mr que puede empezar
    private Semaphore bajarse; //para q no se bajen hasta q termine la atraccion
    private int cantLugares; 
    private Semaphore cantVueltas; //para que la atraccion se cierre cuendo ya se dieron las vueltas
    
    public Carro(int cantAsientos, int cantMaxVueltas){
        this.cantLugares=cantAsientos;
        this.asientos= new Semaphore(cantAsientos);
        this.bajarse= new Semaphore(0);
        this.puedeArrancar= new Semaphore(0);
        this.cantVueltas= new Semaphore(cantAsientos*cantMaxVueltas);
    }
    
    public boolean getEstaAbierta(){
        //PARA SIMULAR LA CANTIDAD DE VUELTAS QUE VA A DAR LA ATRACCION ANTES DE Q SE CIERRE!!
      return cantVueltas.tryAcquire();
    }
    
    public void subirmeAlCarro(){
        try {
            //SI CONSIGUE UN ASIENTO SE SUBE SINO ESPERA EN LA FILA (QUE NO HAY PERO SUPONGAMOS Q SI)
            asientos.acquire();
            puedeArrancar.release();
        } catch (Exception e) {
        }
        
    }
    
    public void empezarAtraccion(){
        try {
            //ESPERA HASTA Q TODOS LOS LUGARES ESTEN LLENOS
            puedeArrancar.acquire(cantLugares);
             }
          catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void terminarAtraccion(){
        //LE AVISA A LOS CLIENTES Q YA SE PUEDEN BAJAR
        bajarse.release(cantLugares);
    }
    
    public void intertarBajarme(){
        try {
            //PARA Q LOS CLIENTES NO SE BAJEN A MITA DEL RECORRIDO, VISTE?
            bajarse.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void bajarmeAtraccion(){
        //JA JA LIBERAN EL ASIENTO
        asientos.release();
    }
    
   
    
    
}
