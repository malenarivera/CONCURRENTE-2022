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
public class Canibal implements Runnable{
    Olla o;
    
    public Canibal (Olla o){
        this.o=o;
    }
    
    
    public void run(){
        o.comer();
        this.simularComer();
}
    
    
    private void simularComer(){
        try {
            System.out.println(Thread.currentThread().getName()+" Comiendo!!");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
