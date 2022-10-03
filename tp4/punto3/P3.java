/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto3;

/**
 *
 * @author male_
 */
public class P3 implements Runnable{
     SemaforosProcesos s;
    
    public P3 (SemaforosProcesos s){
        this.s=s;
    }
    
    public void run(){
        while(true){
            s.adquirirP3();
            System.out.println("im just el proceso p3 ejecutandome uwu");
            s.liberarP2();
    }
    }
    
}
