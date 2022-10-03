/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto6;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainPollosHermanos {
    public static void main(String[] args) {
        Confiteria c= new Confiteria();
        EmpleadoPolleria[] em;
        Thread [] thEmp;
                
        System.out.println("Ingrese la cantidad de empleados");
        int cantEmpleados=TecladoIn.readLineInt();
        em= new EmpleadoPolleria[cantEmpleados];
        thEmp= new Thread [cantEmpleados];
        
        Mozo mozo= new Mozo(c,cantEmpleados);
        Thread mozito= new Thread(mozo, "Mozo");
        mozito.start();
        
        for (int i = 0; i < cantEmpleados; i++) {
            em[i]= new EmpleadoPolleria(c);
            thEmp[i]= new Thread(em[i], "Empleado "+i);
        }
        
        for (int i = 0; i < cantEmpleados; i++) {
            thEmp[i].start();
            
        }
    }
    
}
