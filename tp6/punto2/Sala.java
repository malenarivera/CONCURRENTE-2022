/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Sala {
  private ReentrantLock mutexEntrar   = new ReentrantLock();
  private Condition jubilado= mutexEntrar.newCondition();
  private Condition normal= mutexEntrar.newCondition();
  private int tUmbral=30;
  private int cantMaxPersonas=50;
  private int cantPersonas=0;
  private int cantPersonasJubiladasEsperando=0;
  
public void entrarSala(){
    mutexEntrar.lock();
    while(cantPersonas>cantMaxPersonas){
        System.out.println(Thread.currentThread().getName()+": Debe esperar");
        try {
            normal.await();
        } catch (InterruptedException ex) {
        }
    }
    System.out.println(Thread.currentThread().getName()+": Entro a la sala");
    cantPersonas++;
    mutexEntrar.unlock();
}

public void salirSala(){
    mutexEntrar.lock();
    System.out.println("Se va de la sala!");
    if(cantPersonasJubiladasEsperando>0)
        jubilado.signal();
    else
        normal.signal();
    cantPersonas--;
    mutexEntrar.unlock();
}

public void entrarJubilado(){
    mutexEntrar.lock();
    while(cantPersonas>cantMaxPersonas){
        System.out.println(Thread.currentThread().getName()+": Soy jubilado y espero uwu");
        cantPersonasJubiladasEsperando++;
        try {
            jubilado.await();
        } catch (InterruptedException ex) {
        }
    }
    if(cantPersonasJubiladasEsperando>0){
        cantPersonasJubiladasEsperando--;
    }
    System.out.println(Thread.currentThread().getName()+": Soy jubilado y entro");
    cantPersonas++;
    mutexEntrar.unlock();
}

public void notificarTemperatura (int temp){
    if(temp>tUmbral){
        System.out.println("Se paso el umbral, cambio la cant personas a 35");
        cantMaxPersonas=35;
    }else{
        System.out.println("Se vuelve a la temperatura normal!!");
        cantMaxPersonas=50;
        if(cantPersonasJubiladasEsperando>0)
            jubilado.signalAll();
        normal.signalAll();
    }
    System.out.println("La temperatura Actual es de: "+temp);
}

}
