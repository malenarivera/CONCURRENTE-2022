/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author male_
 */
public class Centro {
    private ReentrantLock mutex= new ReentrantLock();
    private Condition esperaCamilla= mutex.newCondition();
    private Condition esperaRevista= mutex.newCondition();
    private int cantCamillasLibres;
    private int cantRevistasLibres;
    private int cantSillasSalaEsperaLibres;
    
    public Centro(int cantSillasSalaEspera){
        cantCamillasLibres=4;
        cantRevistasLibres=9;
        this.cantSillasSalaEsperaLibres= cantSillasSalaEspera;
    }
    
    public void entrar(){
        mutex.lock();
        if(cantCamillasLibres==0){
            if(cantSillasSalaEsperaLibres==0){
                System.out.println(Thread.currentThread().getName()+": Espera parado");
            }
            if(cantRevistasLibres==0){
                System.out.println(Thread.currentThread().getName()+": Mira tele mientras espera una revista");
                try {
                    esperaRevista.await();
                } catch (InterruptedException ex) {
                }
                
            }else{
                System.out.println(Thread.currentThread().getName()+": Espera leyendo la revista");
                cantRevistasLibres--;
            }
                
                
        }
    }
    
}
