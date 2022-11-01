/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Observatorio {
    private int capacidadMaxima=50;
    private ReentrantLock mutexEntrarSillaRuedas= new ReentrantLock();
    private ReentrantLock mutexEntrarSala= new ReentrantLock();
    private Condition esperarEntrar= mutexEntrarSala.newCondition();
    private int cantPersonasSala=0;
    
    public void entrarSala(){
        mutexEntrarSala.lock();
        while(cantPersonasSala>capacidadMaxima){
            try {
                esperarEntrar.await();
            } catch (InterruptedException ex) {
            }
        }
        cantPersonasSala++;
        mutexEntrarSala.unlock();
    }
    
    public void entrarSalaSillaRuedas(){
        mutexEntrarSillaRuedas.lock();
        mutexEntrarSala.lock();
        while(cantPersonasSala>capacidadMaxima){
            try {
                esperarEntrar.await();
            } catch (InterruptedException ex) {
            }
        }
        capacidadMaxima=30;
        cantPersonasSala++;
        mutexEntrarSala.unlock();
    }
    
    public void salirSala(){
        mutexEntrarSala.lock();
        System.out.println(Thread.currentThread().getName()+": Salio de la sala");
        cantPersonasSala--;
        esperarEntrar.signal();
        mutexEntrarSala.unlock();
    }
    
    public void salirSalaSilla(){
        mutexEntrarSala.lock();
        System.out.println(Thread.currentThread().getName()+": Salio de la sala en silla de ruedas");
        cantPersonasSala--;
        capacidadMaxima=50;
        mutexEntrarSillaRuedas.unlock();
        esperarEntrar.signalAll();
        mutexEntrarSala.unlock();
    }
}
