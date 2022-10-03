/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p3;

import universidad.concurrente.tp3.p3.SalaConcierto;
import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainConcierto {
    public static void main(String[] args) {
        SalaConcierto sala;
        Encargado encargado;
        System.out.println("Ingrese la cantidad de asientos para la sala");
        
        int asientos=TecladoIn.readLineInt();
        while(asientos<=0){
            System.out.println("nono, otra be");
            asientos=TecladoIn.readLineInt();
        }
        sala= new SalaConcierto(asientos);
        encargado= new Encargado(sala);
        System.out.println("Ingrese la cantidad de clientes");
        int clientess= TecladoIn.readLineInt();
        ClienteConcierto [] cc = new ClienteConcierto[clientess];
        Thread [] cct= new Thread[clientess];
        
        
      
        for (int i = 0; i < clientess; i++) {
            cc[i]= new ClienteConcierto(encargado);
        }
        
        for (int i = 0; i < clientess; i++) {
            cct[i]= new Thread (cc[i], "Cliente "+i);
        }
        
        for (int i = 0; i < clientess; i++) {
            cct[i].start(); 
        }
        
        for (int i = 0; i < clientess; i++) {
            try {
                cct[i].join();
            } catch (Exception e) {
            }
            
        }
       
    
}
}
