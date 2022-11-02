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
        PersonaMantenimiento pm[]= new PersonaMantenimiento[10];
        Investigador in[]= new Investigador[4];
        Thread personitas[]= new Thread[100];
        Thread personitasMantenimiento[]= new Thread[pm.length];
        Thread investigadores[]= new Thread[in.length];
        
        for (int i = 0; i < p.length; i++) {
            p[i]= new Persona(o);
            personitas[i]= new Thread(p[i], "Persona "+i);
        }
        for (int i = 0; i < pm.length; i++) {
            pm[i]= new PersonaMantenimiento(o);
            personitasMantenimiento[i]= new Thread(pm[i], "Persona Mantenimiento "+i);
        }
        
        for (int i = 0; i < in.length; i++) {
            in[i]= new Investigador(o);
            investigadores[i]= new Thread(in[i], "Investigador "+i);
        }
        
        for (int i = 0; i < pm.length; i++) {
            personitasMantenimiento[i].start();
        }
        for (int i = 0; i < in.length; i++) {
            investigadores[i].start();
        }
        
        for (int i = 0; i < p.length; i++) {
            personitas[i].start();
        }
    }
}
