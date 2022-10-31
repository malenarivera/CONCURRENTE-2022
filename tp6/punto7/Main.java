/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto7;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese la cant de canibales");
        int cantCanibales= TecladoIn.readLineInt();
        System.out.println("Ingrese la cant de raciones de la olla");
        int cantRaciones= TecladoIn.readLineInt();
        
        Olla o = new Olla(cantRaciones);
        Cocinero co= new Cocinero(o);
        Thread cocinerito= new Thread(co);
        cocinerito.start();
        
        Canibal c[]= new Canibal[cantCanibales];
        Thread canibales[]= new Thread[cantCanibales];
        
        for (int i = 0; i < c.length; i++) {
            c[i]= new Canibal(o);
            canibales[i]= new Thread(c[i], "Canibal "+i);
        }
        
        for (int i = 0; i <cantCanibales; i++) {
            canibales[i].start();
            
        }
        
    }
    
}
