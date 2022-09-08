/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainHamster {
        private static Jaula j= new Jaula();
        private static int cantHamsters;
        private static Hamster [] hamsters;
        private static Thread [] th;
        private static Rueda r = new Rueda();
        private static Hamaca h= new Hamaca();
        private static Comida c= new Comida();
          
    public static void main(String[] args) {
          System.out.println("Cuantos hamsters?");
          cantHamsters= TecladoIn.readLineInt();
          crearHamsters();
          crearHilos();
          empezarHilos();
    }
    
          private static void crearHamsters(){
             hamsters= new Hamster[cantHamsters];
              for (int i = 0; i < cantHamsters; i++) {
                  hamsters[i]= new Hamster(r,h,c);
              }
          }
          
          private static void crearHilos(){
              th= new Thread[cantHamsters];
              for (int i = 0; i < cantHamsters; i++) {
                  th[i]= new Thread(hamsters[i], "Hamster "+i);
                  
              }
          }
          
        private static void empezarHilos(){
            for (int i = 0; i < th.length; i++) {
                th[i].start();
            }
        }

    }
    

