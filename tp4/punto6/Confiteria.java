/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class Confiteria {
    private Semaphore asiento;
    private Semaphore puedeCocinar;
    private Semaphore puedeComer;
    
    
    public Confiteria(){
        asiento=new Semaphore(1);
        puedeCocinar= new Semaphore(0);
        puedeComer= new Semaphore(0);
    }
    
    public void agarrarAsiento(){
        try {
            asiento.acquire();
        } catch (Exception e) {
        }
    }
    public void liberarAsiento(){
        asiento.release();
    }
    
    public void agarrarPuedeCocinar(){
        try {
            puedeCocinar.acquire();
        } catch (Exception e) {
        }
    }
    public void liberarPuedeCocinar(){
        puedeCocinar.release();
    }
    
    public void agarrarPuedeComer(){
        try {
            puedeComer.acquire();
        } catch (Exception e) {
        }
    }
    public void liberarPuedeComer(){
        puedeComer.release();
    }
    
}
