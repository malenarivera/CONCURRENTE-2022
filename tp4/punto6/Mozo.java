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
public class Mozo implements Runnable {
    Confiteria c;
    int cantClientes;
    
    public Mozo(Confiteria c, int cantClientes){
        this.c=c;
        this.cantClientes=cantClientes;
    }
    
    public void run(){
        int cont=0;
        while(cont<cantClientes){
            c.agarrarPuedeCocinar();
            this.simularCocina();
            System.out.println(Thread.currentThread().getName()+": Le entrego el pedido al cliente");
            c.liberarPuedeComer();
            cont++;
        }
    }
    
    private void simularCocina(){
        try {
            System.out.println(Thread.currentThread().getName()+" estoy cocinando");
            Thread.sleep(1000);
            
        } catch (Exception e) {
        }
    }
    
}
