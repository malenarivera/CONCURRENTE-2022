/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto1;

import java.util.Scanner;

/**
 *
 * @author male_
 */
public class Main {
    
    public static void main(String[] args) {
        GestionTrafico gt= new GestionTrafico();
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese la cant de autos");
        int cant= sc.nextInt();
        Auto a[]= new Auto[cant];
        Thread autitos[]= new Thread[cant];
        
        for (int i = 0; i < cant; i++) {
            a[i]= new Auto((i%2), gt);
           autitos[i]= new Thread(a[i], "Auto "+i);
        }
        for (int i = 0; i < cant; i++) {
            autitos[i].start();
            
        }
    }
    
}
