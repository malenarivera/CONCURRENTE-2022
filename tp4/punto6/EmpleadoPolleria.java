/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto6;

/**
 *
 * @author male_
 */
public class EmpleadoPolleria implements Runnable {
    Confiteria c;
    
    public EmpleadoPolleria(Confiteria c){
        this.c=c;
    }
    
    public void run(){
        c.agarrarAsiento();
        System.out.println(Thread.currentThread().getName()+": Me sente");
        c.liberarPuedeCocinar();
        c.agarrarPuedeComer();
        this.simularComer();
        System.out.println(Thread.currentThread().getName()+": Me fui");
        c.liberarAsiento();
    
    }
    
    
    private void simularComer(){
        try {
            System.out.println(Thread.currentThread().getName()+": Estoy comiendo");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
}
    
    
}
