/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp2;

/**
 *
 * @author male_
 */
public class testeoRecurso {
    public static void main(String[] args) {
        Cliente juan= new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines= new Cliente();
        ines.setName("Ines Garcia");
        juan.start();
        ines.start();
        Recurso.uso();
    }
}
