/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto6;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
        Paciente p[]= new Paciente[20];
        Centro c = new Centro();
        Thread pacientes[]= new Thread[p.length];
        
        for (int i = 0; i < pacientes.length; i++) {
            p[i]= new Paciente(c);
            pacientes[i]= new Thread(p[i], "Paciente "+i);
        }
        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i].start();
        }
        
        
    }
    
}
