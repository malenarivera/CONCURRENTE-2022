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
    private ReentrantLock mutexEntrar = new ReentrantLock();
    private Condition esperarCamilla= mutexEntrar.newCondition();
    private Condition esperarRevista= mutexEntrar.newCondition();
    private int cantRevistas=9;
    private int cantCamillas=4;
    private int cantCamillasOcupadas=0;
    private int cantRevistasOcupadas=0;
    
    
    public void entrarSala(){
        mutexEntrar.lock();
        boolean tieneRevista=false;
        while(cantCamillasOcupadas>=cantCamillas){
            tieneRevista=true;
            this.irSalaEspera();
            try {
                esperarCamilla.await();
            } catch (InterruptedException ex) {
            }
            
        }
        if(tieneRevista)
            this.dejarRevista();
        cantCamillasOcupadas++;
        mutexEntrar.unlock();
    }
    
    private void irSalaEspera(){
        
        while(cantRevistasOcupadas>=cantRevistas){
            System.out.println(Thread.currentThread().getName()+": Espero por la camilla mientras miro tele");
            try {
                esperarRevista.await();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(Thread.currentThread().getName()+": Espero por la camilla mientras leo una revista");
        cantRevistasOcupadas++;
    }
    
    public void salirSala(){
        mutexEntrar.lock();
        System.out.println(Thread.currentThread().getName()+": Me voy");
        cantCamillasOcupadas--;
        esperarCamilla.signal();
        mutexEntrar.unlock();
    }
    
    private void dejarRevista(){
        System.out.println(Thread.currentThread().getName()+": hay una camilla libre, dejo mi revista");
        cantRevistasOcupadas--;
        esperarRevista.signal();
    }
}
