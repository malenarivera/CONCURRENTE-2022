/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.segundoParcial.temaTres;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class Main {
    
    public static void main(String[] args) {
        Cliente c[];
        Thread tc[];
        Carro ca;
        MontañaRusa mr;
        Thread tmr;
        System.out.println("Los print se van a imprimir en cualquier lado, pero weno pibe, asi es la concurrencia");
        System.out.println("Ingrese la cant de lugares en el carro");
        int cantLugares= TecladoIn.readLineInt();
        System.out.println("Ingrese la cant de vuueltas max");
        int cantVueltasMax= TecladoIn.readLineInt();
        System.out.println("Ingrese la cant de clientes");
        int cantClientes= TecladoIn.readLineInt();
        
        ca= new Carro(cantLugares,cantVueltasMax);
        c= new Cliente[cantClientes];
        tc= new Thread[c.length];
        mr= new MontañaRusa(ca, cantVueltasMax);
        tmr= new Thread (mr);
        tmr.start();
        
        
        
        for (int i = 0; i < c.length ; i++) {
            c[i]= new Cliente (ca);
            tc[i]= new Thread(c[i], "Cliente "+i);
            
        }
        
         for (int i = 0; i < c.length ; i++) {
            tc[i].start();
            
        }
        
    }
    
}
