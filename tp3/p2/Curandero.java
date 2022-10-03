/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p2;

import universidad.concurrente.tp3.p2.Vida;

/**
 *
 * @author male_
 */
public class Curandero implements Runnable{
    private Vida unaVida;
    
    public Curandero (Vida unaVida){
        this.unaVida=unaVida;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"Cura");
            unaVida.setVida(3);
           // this.simularTiempo(i);
           System.out.println(unaVida.getVida()+ " Despues de la cura de "+Thread.currentThread().getName());
        }
    }
    
    private void simularTiempo(int i){
        try {
            Thread.sleep(i*10);
        } catch (Exception e) {
        }
    }
    
}
