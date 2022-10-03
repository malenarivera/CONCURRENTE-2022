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
public class MainCajero {
    public static void main(String[] args) {
    ClienteCajero cliente1 = new ClienteCajero("Cliente 1", new int[] {2,2,1,5,2,3});
    ClienteCajero cliente2 = new ClienteCajero("Cliente 2", new int[] {1,3,5,1,1});
    Cajero cajero1 = new Cajero("Cajero 1");
// Tiempo inicial de referencia
    long initialTime = System.currentTimeMillis();
    cajero1.procesarCompra(cliente1, initialTime);
    cajero1.procesarCompra(cliente2, initialTime);
}

    
}
