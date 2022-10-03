/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p2;

import universidad.concurrente.tp3.p2.Curandero;
import universidad.concurrente.tp3.p2.Orco;
import universidad.concurrente.tp3.p2.Vida;

/**
 *
 * @author male_
 */
public class MainCuranderoOrco {
    public static void main(String[] args) {
        Vida unaVida= new Vida();
       Orco o1= new Orco(unaVida);
       // Orco o2= new Orco(unaVida);
        Curandero c1= new Curandero(unaVida);
       // Curandero c2= new Curandero(unaVida);
        
        Thread t1= new Thread(o1, "Orco 1 ");
       // Thread t2= new Thread(o2, "Orco 2 ");
        Thread t3= new Thread(c1, "Curandero 1 ");
      //  Thread t4= new Thread(c2, "Curandero 2 ");
        
        t1.start();
       // t2.start();
        t3.start();
       // t4.start();

       
       
               
    }
    
}
