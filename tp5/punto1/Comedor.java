/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class Comedor {
    
   private Semaphore puedeAtender;
   private Semaphore puedeCocinar;
   private Semaphore puedeComer;
   private Semaphore puedeTomar;
   private Semaphore puedeSentarse;
   private Semaphore mutexMozo;
   private Semaphore mutexCocinero;
   
   
   public Comedor (){
       
       //faltan semaforos? porque el mozo no puede atender a dos empleados al mismo tiemppo pero no se 
       puedeAtender= new Semaphore (0);
       mutexMozo= new Semaphore(1);
       mutexCocinero= new Semaphore(1);
       puedeCocinar= new Semaphore (0);
       puedeComer= new Semaphore (0);
       puedeTomar= new Semaphore(0);
       puedeSentarse= new Semaphore (2);
   }
   
   public void agarraMozo(){
       try {
           mutexMozo.acquire();
       } catch (Exception e) {
       }
   }
   public void liberaMozo(){
       mutexMozo.release();
   }
   
   
   public void agarraCocinero(){
       try {
           mutexCocinero.acquire();
       } catch (Exception e) {
       }
   }
   public void liberaCocinero(){
       mutexCocinero.release();
   }
   
   public boolean puedeSentarse(){
       return puedeSentarse.tryAcquire();
   }
   public void liberaPuedeSentarse(){
       puedeSentarse.release();
   }
   
   
   public void agarraPuedeComer(){
        try {
            puedeComer.acquire();
        } catch (Exception e) {
        }
    }
   public void liberaPuedeComer(){
       puedeComer.release();
   }
   
   
   public void agarraPuedeTomar(){
        try {
            puedeTomar.acquire();
        } catch (Exception e) {
        }
    }
   public void liberaPuedeTomar(){
       puedeTomar.release();
   }
   
   
    public void agarraPuedeAtender(){
        try {
            puedeAtender.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeAtender(){
       puedeAtender.release();
   }
    
    
    public void agarraPuedeCocinar(){
        try {
            puedeCocinar.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeCocinar(){
       puedeCocinar.release();
   }
    
    
}
