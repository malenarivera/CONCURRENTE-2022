/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.consumidorProductor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class RecursoCompartido {
    Semaphore puedeConsumir;
    Semaphore puedeProducir;
    Semaphore mutex; /*?????*/
    boolean [] arreglito= {false, false, false, false};
    int punteroProductor;
    int punteroConsumidor;
    
    public RecursoCompartido (){
        puedeConsumir= new Semaphore(0);
        puedeProducir= new Semaphore (arreglito.length);
        mutex= new Semaphore(1);
        punteroProductor=0;
        punteroConsumidor=0;
    }
    
    public void agarraPuedeConsumir(){
        try {
            puedeConsumir.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeConsumir(){
        puedeConsumir.release();
    }
    
    
    public void agarraPuedeProducir(){
        try {
            puedeProducir.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaPuedeProducir(){
        puedeProducir.release();
    }
    
    
    public void agarrarMutex(){
        try {
            mutex.acquire();
        } catch (Exception e) {
        }
    }
    public void liberaMutex(){
        mutex.release();
    }
    
    public int buscarPosLibreProductor(){
        return punteroProductor;
        
}
    
    public void pone(int i){
       arreglito[i]=true;
       if(punteroProductor==arreglito.length-1)
           punteroProductor=0;
       else
           punteroProductor++;
    }
    
    public int buscarPosLibreConsumidor(){
        return punteroConsumidor;
}
    
    public void saca(int i){
       arreglito[i]=false;
        if(punteroConsumidor==arreglito.length-1)
           punteroConsumidor=0;
       else
           punteroConsumidor++;
    }
    
    
}
