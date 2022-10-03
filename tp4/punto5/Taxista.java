/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto5;

/**
 *
 * @author male_
 */
public class Taxista implements Runnable {
    Taxi t;
    int cantClientes;
    
    public Taxista (Taxi t, int cantClientes){
        this.cantClientes=cantClientes;
        this.t=t;
    }
    
    public void run(){
        int cont=0;
        while(cont<cantClientes){
        t.agarrarConducir();
        this.manejar();
        t.liberarBajarse();
        cont++;
    }
    }
    
    
    private void manejar(){
        try {
            System.out.println(Thread.currentThread().getName()+" estoy manejando");
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
}
