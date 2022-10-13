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
public class Cocinero implements Runnable{
    Comedor c;
    
    public Cocinero(Comedor c){
        this.c=c;
    }
    
    public void run(){
        while(true){
            c.agarraPuedeCocinar();
            this.simulaCocinar();
            c.liberaPuedeComer();
        }
        }
    
    private void simulaCocinar(){
        try {
            System.out.println("Cocinero cocinando");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
}
