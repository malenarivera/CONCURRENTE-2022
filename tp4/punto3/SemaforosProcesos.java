/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class SemaforosProcesos {
     Semaphore p1;
     Semaphore p2;
     Semaphore p3;
    
    public SemaforosProcesos(){
        p1= new Semaphore(1);
        p2= new Semaphore(0);
        p3= new Semaphore(0);
    }
    
    
    public void adquirirP1(){
        try {
            p1.acquire();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException ex) {
        }
    }
    
    public void liberarP1(){
        p1.release();
    }
    
    public void adquirirP2(){
        try {
            p2.acquire();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException ex) {
        }
    }
    
    public void liberarP2(){
        p2.release();
    }
    
    public void adquirirP3(){
        try {
            p3.acquire();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException ex) {
        }
    }
    
    public void liberarP3(){
        p3.release();
    }
}
