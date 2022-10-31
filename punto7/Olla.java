/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Olla {
    private int cantRaciones;
    private ReentrantLock mutex= new ReentrantLock();
    private Condition esperaCanibales= mutex.newCondition();
    private Condition esperaCocinero= mutex.newCondition();
    private int cantTotalRaciones;
    
    
    public Olla(int cantRaciones){
        this.cantTotalRaciones=cantRaciones;
        this.cantRaciones= cantTotalRaciones;
    }
    
    public void comer(){
        mutex.lock();
        while(cantRaciones==0){
            esperaCocinero.signal();
            try {
                esperaCanibales.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         cantRaciones--;
        mutex.unlock();
    }
    
    public void cocinar(){
        mutex.lock();
        if(cantRaciones>0){
            try {
                esperaCocinero.await();
            } catch (InterruptedException ex) {
            }
        }
        
}
    
public void terminaCocinar(){
    mutex.lock();
    cantRaciones=cantTotalRaciones;
    esperaCanibales.signalAll();
    mutex.unlock();
}
}
