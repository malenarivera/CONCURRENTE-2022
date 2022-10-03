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
public class Orco implements Runnable{
    private Vida unaVida;
    
    public Orco (Vida unaVida){
        this.unaVida=unaVida;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"golpea");
            unaVida.setVida(-3);
           // this.simularTiempo(i);
            System.out.println(unaVida.getVida()+ " Despues del ataque de "+Thread.currentThread().getName());
          
        }
        
    }
     private void simularTiempo(int i){
        try {
            Thread.sleep(i*10);
        } catch (Exception e) {
        }
    
}
}
