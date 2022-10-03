/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p4;

import universidad.concurrente.tp3.p4.Rueda;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Hamster implements Runnable {
    Rueda r= new Rueda();
    Comida c= new Comida();
    Hamaca h= new Hamaca();
    
    public Hamster(Rueda r, Hamaca h, Comida c){
        this.r=r;
        this.h=h;
        this.c=c;
        
    }
    
    
    @Override
    public void run(){
      r.realizarActividad();
      h.realizarActividad();
      c.realizarActividad();
    
    }
    
    
}
