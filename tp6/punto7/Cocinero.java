/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto7;

/**
 *
 * @author male_
 */
public class Cocinero implements Runnable{
    Olla o;
    
    public Cocinero(Olla o){
        this.o=o;
    }
    
    public void run(){
        while(true){
        o.cocinar();
        this.simulaCocina();
        o.terminaCocinar();
    }
    }
    
    private void simulaCocina(){
        try {
            System.out.println("Cocinandoooo");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
        
        
    
}
