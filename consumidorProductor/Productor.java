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
public class Productor implements Runnable{
    RecursoCompartido r;
    
    public Productor (RecursoCompartido r){
        this.r=r;
    }
    
    public void run(){
        r.agarraPuedeProducir();
        r.agarrarMutex();
        this.simula();
        r.liberaMutex();
        r.liberaPuedeConsumir();
    }
    
    
    private void simula(){
        try{
            System.out.println(Thread.currentThread().getName()+": Produciendo");
            Thread.sleep(1000);
            int pos= r.buscarPosLibreProductor();
            r.pone(pos);
        } catch (Exception e) {
        }
    }

}
