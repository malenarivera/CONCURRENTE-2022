/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.consumidorProductor;

/**
 *
 * @author male_
 */
public class Consumidor implements Runnable {
    RecursoCompartido r;
    
    public Consumidor (RecursoCompartido r){
        this.r=r;
    }
    
    public void run(){
        r.agarraPuedeConsumir();
        r.agarrarMutex();
        this.simula();
        r.liberaMutex();
        r.liberaPuedeProducir();
    }
    
    private void simula(){
        try{
            System.out.println(Thread.currentThread().getName()+" consummiendo");
            Thread.sleep(1000);
            int pos= r.buscarPosLibreConsumidor();
            r.saca(pos);
        } catch (Exception e) {
        }
    }
}
