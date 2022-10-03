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
public class P2 implements Runnable{
     SemaforosProcesos s;
    
    public P2 (SemaforosProcesos s){
        this.s=s;
    }
    
    public void run(){
        while(true){
            s.adquirirP2();
            System.out.println("lol, aca estoy en p2");
            s.liberarP1();
    }
    }
    
}
