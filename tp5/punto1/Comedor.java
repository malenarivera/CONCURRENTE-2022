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
   private Semaphore asientos;
   //estos los tengo porque no se si el mozo tiene que atender a uno por vez
   //igual no creo porque sino se corta la concurrencia juas
   //los tengo pa nada porque no los uso pero por las dudas dps los use jaja cuando pregunte en PRACTICA
   private Semaphore mutexMozo;
   private Semaphore mutexCocinero;
   
   
   public Comedor (){
       puedeAtender= new Semaphore (0);
       mutexMozo= new Semaphore(1);
       mutexCocinero= new Semaphore(1);
       puedeCocinar= new Semaphore (0);
       puedeComer= new Semaphore (0);
       puedeTomar= new Semaphore(0);
       asientos= new Semaphore (2);
   }
   
   //no prestar atencion a estos metodos los tengo por las dudas jeje
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
   
   // METODOS IMPORTANTES DE ACA PARA ABAJO
   
   
   public boolean puedeSentarse(){
       //si hay un asiento libre lo agarra y se sienta
       return asientos.tryAcquire();
   }
   public void liberaPuedeSentarse(){
       //libera el asiento cuando se va pa q entre otro empleado
       asientos.release();
   }
   
   
   public void agarraPuedeComer(){
       //para controlar que el empleado no coma hasta q la comida no este lista
        try {
            puedeComer.acquire();
        } catch (Exception e) {
        }
    }
   public void liberaPuedeComer(){
       //lo libera el cocinero cuando termino de cocinar
       puedeComer.release();
   }
   
   
   public void agarraPuedeTomar(){
       //para controlar que el empleado no tome nada hasta q no se lo traiga el mozo
        try {
            puedeTomar.acquire();
        } catch (Exception e) {
        }
    }
   public void liberaPuedeTomar(){
       //lo libera el mozo cuando consigue la bebida que pidio el empleado
       puedeTomar.release();
   }
   
   
    public void agarraPuedeAtender(){
        //para controlar que el mozo no atienda cuando no hay nadie
        try {
            puedeAtender.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeAtender(){
        //los empleados que quieran algo pa tomar liberan permisos 
        //(en algun momento puedeAtender puede tener 2 permisos disponibles)
        //esto supongo que esta bien porque el mozo puede atender 2 mesas al mismo tiempo
       puedeAtender.release();
   }
    
    
    public void agarraPuedeCocinar(){
        //para controlar que el cocinero no cocine cuando no hay nadie
        try {
            puedeCocinar.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeCocinar(){
        //lo liberan los empleados que quieran algo pa comer
        //en algun momento puedeCocinar puede tener 2 permisos disponibles
        //esto supongo que esta bien porque el cocinero puede cocinar 2 cosas a la vez
       puedeCocinar.release();
   }
    
    
}
