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
public class ThreadEjemploR implements Runnable{
    
    public void run(){
        for (int i = 0; i < 10; i++) {
         System.out.println(i+" "+Thread.currentThread().getName());
        }
        System.out.println("Termina thread "+Thread.currentThread().getName());
    }
        
  
    
}

