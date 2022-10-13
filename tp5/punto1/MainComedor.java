/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto1;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainComedor {
   private static Comedor c= new Comedor();
   private static  Empleado[]e;
   private static  Cocinero cocinerito= new Cocinero(c);
   private static Mozo mozito = new Mozo (c);
   private static Thread mozo;
   private static  Thread cocinero;
   private static Thread []empleados;
    
    
    public static void main(String[] args) {
        System.out.println("Ingrese la cant de empleados");
        int cantEmp= TecladoIn.readLineInt();
        inicializarEmpleado(cantEmp);
        cocinero= new Thread(cocinerito, "Cocinero");
        mozo= new Thread(mozito, "Mozo");
        iniciarHilos();
        
    }
    
    private static void inicializarEmpleado(int cant){
        e= new Empleado[cant];
        empleados= new Thread [cant];
    
        for (int i = 0; i < e.length; i++) {
            e[i]= new Empleado(c);
            empleados[i]= new Thread (e[i], "Empleado "+i);
        }
        
    }
    
    private static void iniciarHilos(){
        for (int i = 0; i < empleados.length; i++) {
            empleados[i].start();
        }
        cocinero.start();
        mozo.start();
    }
    
}
