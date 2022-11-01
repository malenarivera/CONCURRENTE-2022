/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto4;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
        Observatorio o= new Observatorio();
        
        Persona p[]= new Persona[100];
        Thread personitas[]= new Thread[100];
        
        for (int i = 0; i < p.length; i++) {
            p[i]= new Persona(o);
            personitas[i]= new Thread(p[i], "Persona "+i);
        }
        for (int i = 0; i < p.length; i++) {
            personitas[i].start();
        }
    }
}
