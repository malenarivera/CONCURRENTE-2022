/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto5;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainTaxista {
    public static void main(String[] args) {
        Taxi t= new Taxi();
       
        
         ClienteTaxi []ct;
         Thread []tct;
        
        System.out.println("Ingrese cantidad de pasajeros");
        int cantPasajeros= TecladoIn.readLineInt();
        ct= new ClienteTaxi[cantPasajeros];
        tct= new Thread[cantPasajeros];
        Taxista taxista= new Taxista(t,cantPasajeros);
        Thread ttaxista= new Thread (taxista, "Taxista");
        
        for (int i = 0; i < ct.length; i++) {
            ct[i]= new ClienteTaxi(t);
            tct[i]= new Thread(ct[i], "Cliente "+i);
        }
        
        ttaxista.start();
        for (int i = 0; i < ct.length; i++) {
            tct[i].start();
            
        }
    }
}
