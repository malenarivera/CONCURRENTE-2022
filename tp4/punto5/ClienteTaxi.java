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
public class ClienteTaxi implements Runnable {
    Taxi t;
    
    public ClienteTaxi(Taxi t){
        this.t=t;
    }
    
    public void run(){
        t.agarrarAsiento();
        System.out.println(Thread.currentThread().getName()+": Me subi");
        t.liberarConducir();
        t.agarrarBajarse();
        System.out.println(Thread.currentThread().getName()+": Me baje");
        t.liberarAsiento();
    
    }
    
}
