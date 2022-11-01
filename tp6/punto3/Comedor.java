/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Comedor {
    private ReentrantLock mutexMostrador= new ReentrantLock();
    private ReentrantLock mutexAbridor= new ReentrantLock();
    private ReentrantLock mutexPostre= new ReentrantLock();
    private Condition soldadoEsperandoBandejaComida = mutexMostrador.newCondition();
    private Condition soldadoEsperandoAbridor= mutexAbridor.newCondition();
    private Condition soldadoEsperandoPostre= mutexPostre.newCondition();
    private int cantMostradoresOcupados=0;
    private int cantMostradoresPostresOcupados=0;
    private int cantAbridoresOcupados=0;
    
    public void entrarMostrador(){
        mutexMostrador.lock();
        while(cantMostradoresOcupados==5){
            try {
                soldadoEsperandoBandejaComida.await();
            } catch (InterruptedException ex) {
            }
        }
        cantMostradoresOcupados++;
        mutexMostrador.unlock();
    }
    
    public void abandonarMostrador(){
        mutexMostrador.lock();
        System.out.println(Thread.currentThread().getName()+": Abandono el mostrador");
        cantMostradoresOcupados--;
        soldadoEsperandoBandejaComida.signal();
        mutexMostrador.unlock();
    }
    
    public void abrirBotella(){
        mutexAbridor.lock();
        while(cantAbridoresOcupados==10){
            try {
                soldadoEsperandoAbridor.await();
            } catch (InterruptedException ex) {
            }
            
        }
        cantAbridoresOcupados++;
        mutexAbridor.unlock();
    }
    
    public void terminarAbrirBotella(){
        mutexAbridor.lock();
        System.out.println(Thread.currentThread().getName()+": Termino de abrir la botella. Devuelve el abridor");
        cantAbridoresOcupados--;
        soldadoEsperandoAbridor.signal();
        mutexAbridor.unlock();
    }
    
    
    public void servirsePostre(){
        mutexPostre.lock();
        while(cantMostradoresPostresOcupados==3){
            try {
                soldadoEsperandoPostre.await();
            } catch (InterruptedException ex) {
            }
        }
        cantMostradoresPostresOcupados++;
        mutexPostre.unlock();
    }
    
    public void terminoPostre(){
        mutexPostre.lock();
        System.out.println(Thread.currentThread().getName()+": Terminaron de servirle el postre, se va");
        cantMostradoresPostresOcupados--;
        soldadoEsperandoPostre.signal();
        mutexPostre.unlock();
    }
}
