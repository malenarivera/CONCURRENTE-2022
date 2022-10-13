/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto1;

/**
 *
 * @author male_
 */
public class Mozo implements Runnable{
    Comedor c;
    
    public Mozo (Comedor c){
        this.c=c;
    }
    
    public void run(){
        while(true){
            c.agarraPuedeAtender();
            this.simulaAtender();
            c.liberaPuedeTomar();
        }
    }
    
     private void simulaAtender(){
        try {
            System.out.println("Mozo atendiendo");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
}
