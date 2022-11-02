/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto4;

/**
 *
 * @author male_
 */
public class Investigador implements Runnable{
    Observatorio o;
    
    public Investigador(Observatorio o){
        this.o=o;
    }
    
    public void run(){
        o.entrarInvestigador();
        System.out.println(Thread.currentThread().getName()+": Entro a investigar!");
        this.simularTiempo(); //simula el tiempo que le toma investigar
        o.salirInvestigador();
    }
    
    private void simularTiempo(){
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    
}
