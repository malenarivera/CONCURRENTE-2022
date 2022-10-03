/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp2;

/**
 *
 * @author male_
 */
public class MiHiloT extends Thread{
    
    MiHiloT (String nombre){
        super(nombre);
    }
    
    
    public void run(){
        System.out.println("Comenzando "+Thread.currentThread().getName());
       try{
        for (int contar = 0; contar < 10; contar++) {
            Thread.sleep(400);
            System.out.println("En "+Thread.currentThread().getName()+", el recuento "+contar);
        }
    }catch(InterruptedException exc){
            System.out.println(Thread.currentThread().getName()+" Interrumpido");
    }
        System.out.println("Terminando "+Thread.currentThread().getName());
}
    
    
    
    
    
}
