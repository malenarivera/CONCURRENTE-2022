/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Main {

    public static void main(String[] args) {
        int i=0;
        Scanner s= new Scanner(System.in);


        System.out.println("Ingrese la cantidad de atomos de oxigeno");
        int cantOxigeno=s.nextInt();
        int cantHidrogeno=cantOxigeno*2;
        int cantAtomos= cantOxigeno+cantHidrogeno;
        
        Thread atomos[]= new Thread[cantAtomos];
        char tipo;

        System.out.println("Ingrese la capacidad del recipiente");
        int capRecipientes=s.nextInt();
        Espacio e= new Espacio(capRecipientes);
    
       

        for (int j=0;j<atomos.length;j++){
            if (j<cantOxigeno){
                tipo='O';
            }
            else{
                tipo='H';

            }

            if (j%2==0){
                atomos[j]= new Thread(new Atomo (e,tipo,true));
            }
            else{
                atomos[j]= new Thread(new Atomo (e,tipo,false));
            }

           
        }
        Thread recipiente = new Thread(new Recipiente(e));
        recipiente.start();
        
        for (int j=0;j<atomos.length;j++){
            atomos[j].start();
        }

    }
    
}