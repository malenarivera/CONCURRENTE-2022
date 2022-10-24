/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto3;

import java.util.Scanner;

/**
 *
 * @author  GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Main {
     public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de hilos durmientes");
        int n=s.nextInt();

        Reloj r= new Reloj(n);
        Thread hilosDurmientes[]= new Thread[n];
        Thread controlReloj= new Thread(new ControlReloj(r));

        for(int i=0;i<hilosDurmientes.length;i++) {
            hilosDurmientes[i]= new Thread(new HiloTrabajador(r,i), "Trabajador "+i);
        }
        for(int i=0;i<hilosDurmientes.length;i++) {
            hilosDurmientes[i].start();;
        }
        controlReloj.start();

       }
    
}
