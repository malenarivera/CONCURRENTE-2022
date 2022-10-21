/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto1;

import java.util.Scanner;

/**
 *
 * @author @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class MainTransbordador {
   private static RecursoCompartido rc= new RecursoCompartido();
   private static  Auto[]autos;
   private static  Transbordador transbor = new Transbordador(rc);
   private static Thread transbordador;
   private static Thread []threadAutos;
    
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese la cant de autos");
        int cantAutos= sc.nextInt();
        inicializarAutos(cantAutos);
        transbordador= new Thread(transbor);
        iniciarHilos();
        
    }
    
    private static void inicializarAutos(int cant){
        autos= new Auto[cant];
        threadAutos= new Thread [cant];
    
        for (int i = 0; i < autos.length; i++) {
            autos[i]= new Auto(rc);
            threadAutos[i]= new Thread (autos[i], "Auto "+i);
        }
        
    }
    
    private static void iniciarHilos(){
        for (int i = 0; i < threadAutos.length; i++) {
            threadAutos[i].start();
        }
        transbordador.start();
    }
}
