/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.consumidorProductor;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainConsumidorProductor {
    
    public static void main(String[] args) {
        RecursoCompartido r= new RecursoCompartido();
        Consumidor c[];
        Productor p[];
        Thread []thc;
        Thread []thp;
        
        System.out.println("Ingrese la cantidad de productores");
        int cantP= TecladoIn.readLineInt();
        p= new Productor[cantP];
        thp= new Thread[cantP];
        System.out.println("Ingrese la cantidad de Consumidoress");
        int cantC= TecladoIn.readLineInt();
        c= new Consumidor[cantC];
        thc= new Thread[cantC];
        
        for (int i = 0; i < p.length; i++) {
            p[i]= new Productor(r);
            thp[i]= new Thread (p[i], "Productor "+i);
        }
        for (int i = 0; i < c.length ; i++) {
            c[i]= new Consumidor (r);
            thc[i]= new Thread(c[i], "Consumidor "+i);
        }
        
        for (int i = 0; i < p.length; i++) {
            thp[i].start();
        }
        for (int i = 0; i < c.length; i++) {
            thc[i].start();
            
        }
        
        
        
        
    }
    
}
