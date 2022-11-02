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
    private ReentrantLock mutexEntrarSala= new ReentrantLock();
    private Condition esperarEntrar= mutexEntrarSala.newCondition();
    private Condition esperaPersonaMantenimiento= mutexEntrarSala.newCondition();
    private Condition esperarInvestigador= mutexEntrarSala.newCondition();
    private int cantInvestigadores=0;
    private int cantPersonasSala=0;
    private int cantPersonasMantenimiento=0;
    private int personasSillaRuedas=0;
    
    public void entrarSala(){
        mutexEntrarSala.lock();
        try {
            while(cantPersonasSala>=capacidadMaxima || cantPersonasMantenimiento>0 || cantInvestigadores>0){
                try {
                    esperarEntrar.await();
                } catch (InterruptedException ex) {
                }
            }
            cantPersonasSala++;
        } finally {
            mutexEntrarSala.unlock();
        }
    }
    
    public void entrarSalaSillaRuedas(){
        mutexEntrarSala.lock();
        try {
            while(cantPersonasSala>=capacidadMaxima || cantPersonasMantenimiento>0 || cantInvestigadores>0){
                try {
                    esperarEntrar.await();
                } catch (InterruptedException ex) {
                }
            }
            capacidadMaxima=30;
            cantPersonasSala++;
            personasSillaRuedas++;
        } finally {
            mutexEntrarSala.unlock();
        }
    }
    
    public void salirSala(){
        mutexEntrarSala.lock();
        try {
            System.out.println(Thread.currentThread().getName()+": Salio de la sala");
            cantPersonasSala--;
            if(cantPersonasSala==0){
            esperarInvestigador.signal();
            esperaPersonaMantenimiento.signalAll();
            }
            esperarEntrar.signal();
            
            //cuando sale libera el lock de la silla
        } finally {
            mutexEntrarSala.unlock();
        }
    }
    
    
    public void salirSalaSilla(){
        mutexEntrarSala.lock();
        try {
            System.out.println(Thread.currentThread().getName()+": Salio de la sala en silla de ruedas");
            cantPersonasSala--;
            if(cantPersonasSala==0){
            esperaPersonaMantenimiento.signalAll();
            esperarInvestigador.signalAll();
            }
            personasSillaRuedas--;
            if(personasSillaRuedas==0){
            capacidadMaxima=50;
            }
        } finally {
         esperarEntrar.signalAll();
         System.out.println("Aviseee silla");
        mutexEntrarSala.unlock();
    }
    }
    
    public void entrarSalaPersonaMantenimiento(){
        mutexEntrarSala.lock();
        try {
            while(cantPersonasSala>0 && personasSillaRuedas>0 || cantInvestigadores>0){
                try {
                    esperaPersonaMantenimiento.await();
                } catch (InterruptedException ex) {
                }
            }
            cantPersonasMantenimiento++;
        } finally {
            mutexEntrarSala.unlock();
        }
    }
    
    public void salirPersonaMantenimiento(){
    mutexEntrarSala.lock();
        try {
            System.out.println(Thread.currentThread().getName()+": Persona de mantenimiento se va");
            cantPersonasMantenimiento--;
            if(cantPersonasMantenimiento==0){
             esperarInvestigador.signalAll();
             esperarEntrar.signalAll();
            }
        } finally {
            mutexEntrarSala.unlock();
        }
        
}
    
public void entrarInvestigador(){
    mutexEntrarSala.lock();
    while(cantPersonasMantenimiento>0 || cantPersonasSala>0 || personasSillaRuedas>0 || cantInvestigadores>=1){
        try {
            esperarInvestigador.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    cantInvestigadores++;
}

public void salirInvestigador(){
    System.out.println(Thread.currentThread().getName()+": Salio el investigador");
     cantInvestigadores--;
    esperaPersonaMantenimiento.signalAll(); 
    esperarEntrar.signalAll();
    mutexEntrarSala.unlock();
 }

}
