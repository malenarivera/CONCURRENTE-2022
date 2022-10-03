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
public class testThreadEjemploR {
    public static void main(String[] args) {
        ThreadEjemploR thr= new ThreadEjemploR();
        
        Thread mj= new Thread(thr,"Maria Jose");
        Thread jm= new Thread(thr, "Jose Maria");
     
        mj.start();
        jm.start();
        System.out.println("Termina Thread main");
    }
    
}
