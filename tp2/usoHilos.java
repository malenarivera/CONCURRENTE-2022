/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp2;

/**
 *
 * @author male_
 */
public class usoHilos {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando");
        
        MiHiloT mht= new MiHiloT("#1");
        MiHiloT mht1= new MiHiloT("#2");
        MiHiloT mht2= new MiHiloT("#3");
       // miHilo mh= new miHilo("#1");
        //Thread nuevoHilo= new Thread(mh);
        
       // nuevoHilo.start();
       mht.start();
       mht1.start();
       mht2.start();
        
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("HIlo principal Interrumpido");
        }
        System.out.println("Hilo principal finalizado");
        
    }
}
