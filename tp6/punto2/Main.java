/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto2;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
        Sala sala= new Sala();
        ControlTemperatura control = new ControlTemperatura(sala);
        Thread controlcito= new Thread(control);
        System.out.println("Ingrese la cant de personas");
        int cantPersonas= TecladoIn.readLineInt();
        Persona personitas[]= new Persona[cantPersonas];
        Thread thpersonitas[]= new Thread[cantPersonas];
        
        for (int i = 0; i < cantPersonas; i++) {
            personitas[i]= new Persona(sala);
            thpersonitas[i]= new Thread(personitas[i], "Persona "+i);
        }
        
        for (int i = 0; i < cantPersonas; i++) {
            thpersonitas[i].start();
        }
        controlcito.start();
        
        
    }
    
}
