/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class Puente {

    private Semaphore semDerecha;
    private Semaphore semIzquierda;
    private Semaphore mutex;
    private Semaphore mutex2;
    private int cantBabuinosEsperandoDer, cantBabuinosEsperandoIzq, cantBabuinosPasando, capacidadSoga;

    public Puente (int capacidadSoga){
        semDerecha= new Semaphore(0);
        semIzquierda= new Semaphore(0);
        mutex= new Semaphore(1);
        mutex2= new Semaphore (1);
        cantBabuinosEsperandoDer=0;
        cantBabuinosEsperandoIzq=0;
        cantBabuinosPasando=0;
        this.capacidadSoga=capacidadSoga;
        
     
    }
    public void pasar(char lado){
        //si soy el primero
       if(mutex2.tryAcquire()){
            if (lado=='I'){
                System.out.println(Thread.currentThread().getName() +" ES EL PRIMER BABUINO Y VIENE DEL LADO IZQ");
                semIzquierda.release(capacidadSoga);
            }
            else{
                System.out.println(Thread.currentThread().getName() +" ES EL PRIMER BABUINO Y VIENE DEL LADO DER");
                semDerecha.release(capacidadSoga);
            }
        
       }
    if(lado=='D')
        this.pasarLadoDer();
    else
        this.pasarLadoIzq();

    
    }

    public void irse (){
        try { mutex.acquire();} catch (InterruptedException e) { e.printStackTrace();}
        cantBabuinosPasando--;
        mutex.release();
    }

    
    private void pasarLadoDer(){
        //si no hay mas permisos significa q no hay mas espacio en la soga y debe esperar
        if (!semDerecha.tryAcquire()){
                System.out.println(Thread.currentThread().getName() +" no pudo pasar");
                this.esperarSegunLado('D');
                System.out.println(Thread.currentThread().getName() +" termino de esperar puede pasar");
                try {
                    mutex.acquire();
                      cantBabuinosEsperandoDer--;
                } catch (InterruptedException e) {}
                mutex.release();

      } else //si pudo conseguir un permiso entonces:
        {
                try { 
                    mutex.acquire();
                } 
                catch (InterruptedException e) {
                }
                cantBabuinosPasando++;
                System.out.println(Thread.currentThread().getName() +" PUDO PASAR " );
                //si soy el ultimo o me pase de la cantidad porque no hay nadie esperando del otro lado
                if (cantBabuinosPasando>=capacidadSoga){
                    //si hay babuinos esperando del otro lado entonces libero sus permisos
                    if (cantBabuinosEsperandoIzq>0){
                        System.out.println(Thread.currentThread().getName() +" ERA EL ULTIMO BABUINO DE LA DERECHA QUE PODIA PASAR Y LE DA EL PASO A LOS DE LA IZQ" );
                        semIzquierda.release(capacidadSoga);
                    }
                  else{
                        //si no hay nadie esperando del otro lado pero SI del MIO entonces libero un permiso para los mios
                        if (cantBabuinosEsperandoDer>0){
                            System.out.println(Thread.currentThread().getName() +" ERA EL ULTIMO BABUINO DE LA DERECHA  PERO NO HABIA DE LA IZQ " );
                            semDerecha.release();
                        }
                    }
                    
                }
                else{ //si no soy el ultimo 
                    //si no hay mas babuinos que pasen por mi lado
                    if(semDerecha.availablePermits()!=0){
                        if(cantBabuinosEsperandoDer==0){//si no hay mas babuinos que pasen por mi lado
                        if (cantBabuinosEsperandoIzq>0){
                            semIzquierda.release(capacidadSoga);
                            semDerecha= new Semaphore(0);
                        }
                    } 
                    }
                  
                
                }
                mutex.release();
                
            }
    }
    
    private void pasarLadoIzq(){
        if (!semIzquierda.tryAcquire()){
             System.out.println(Thread.currentThread().getName() +" no pudo pasar");
                this.esperarSegunLado('I');
                System.out.println(Thread.currentThread().getName() +" termino de esperar puede pasar");
                try {
                    mutex.acquire();
                      cantBabuinosEsperandoIzq--;
                } catch (InterruptedException e) {}
                mutex.release();
        } else{
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cantBabuinosPasando++;
            System.out.println(Thread.currentThread().getName() +" PUDO PASAR " );
            //si soy el ultimo o incluso me pase porque no habia nadie esperando del otro lado
            if (cantBabuinosPasando>=capacidadSoga){
                //si hay babuinos esperando del otro lado libero sus permisos
                if (cantBabuinosEsperandoDer>0){
                    System.out.println(Thread.currentThread().getName() +" ERA EL ULTIMO BABUINO DE LA IZQUIERDA QUE PODIA PASAR Y LE DA EL PASO A LOS DE LA IZQ" );
                    semDerecha.release(capacidadSoga);
                }
                else{
                    //sino libero de los mios
                    if (cantBabuinosEsperandoIzq>0){
                        System.out.println(Thread.currentThread().getName() +" ERA EL ULTIMO BABUINO DE LA DERECHA  PERO NO HABIA DE LA IZQ " );
                        semIzquierda.release();
                    }
                }
                
            }
            else{
                //si no soy el ultimo
                //y ya no hay mas babuinos pasando
              if(semIzquierda.availablePermits()!=0){
                  //si hay babuinos esperando del otro lado entonces libero sus semaforos
                  if(cantBabuinosEsperandoIzq==0){
                    if (cantBabuinosEsperandoDer>0){
                        semDerecha.release(capacidadSoga);
                        semIzquierda= new Semaphore(0);
                    }
                }
              }
            
            }
            mutex.release();
            
        }
        
    }
    
    
    private void esperarSegunLado(char lado){
        System.out.println(Thread.currentThread().getName()+": Debe esperar");
        try {
            mutex.acquire();
            if(lado=='D'){
                cantBabuinosEsperandoDer++;
                semDerecha.acquire();
            }else{
                cantBabuinosEsperandoIzq++;
                semIzquierda.acquire();
            }
        } catch (Exception e) {}
        mutex.release();
        
    }
        
    
}