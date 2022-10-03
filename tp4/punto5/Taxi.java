/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class Taxi {
    private Semaphore conducir, asiento, bajarse;
    
    public Taxi(){
        conducir= new Semaphore(0);
        asiento= new Semaphore(1);
        bajarse= new Semaphore(0);
    }
    
    public void agarrarConducir(){
        try{
        conducir.acquire();
    }catch(InterruptedException e){}
    
    }
    public void liberarConducir(){
        conducir.release();
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
    
    
    public void agarrarBajarse(){
        try {
            bajarse.acquire();
        } catch (Exception e) {
        }
    }
    
    public void liberarBajarse(){
        bajarse.release();
    }
}
