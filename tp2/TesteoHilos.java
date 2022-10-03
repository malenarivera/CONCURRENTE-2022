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
public class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo= new MiEjecucion();
        miHilo.start();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        
        System.out.println("En el main");
    }
}
