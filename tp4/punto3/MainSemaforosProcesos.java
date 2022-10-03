/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto3;

/**
 *
 * @author male_
 */
public class MainSemaforosProcesos {
    public static void main(String[] args) {
        
       SemaforosProcesos s= new SemaforosProcesos(); 
       P1 p1= new P1(s);
       P2 p2 = new P2(s);
       P3 p3= new P3(s);
       
       Thread tp1= new Thread (p1, "Proceso 1");
       Thread tp2= new Thread (p2, "Proceso 2");
       Thread tp3= new Thread (p3, "Proceso 3");
       
       tp1.start();
       
       tp2.start();
       tp3.start();
       
       
    }
}
