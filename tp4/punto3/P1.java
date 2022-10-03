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
public class P1 implements Runnable{
    SemaforosProcesos s;
    
    public P1 (SemaforosProcesos s){
        this.s=s;
    }
    
    public void run(){
        while(true){
            s.adquirirP1();
            System.out.println("jaja ejecutando p1");
            s.liberarP3();
    }
    }
    
    
}
