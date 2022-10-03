/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp2;

import universidad.concurrente.tp2.CajeroThread;
import universidad.concurrente.tp2.ClienteCajero;

/**
 *
 * @author male_
 */
public class MainCajeroThread {

public static void main(String[] args) {
ClienteCajero cliente1 = new ClienteCajero("Cliente 1", new int[] {2,2,1,5,2,3});
ClienteCajero cliente2 = new ClienteCajero("Cliente 2", new int[] {1,3,5,1,1});
 long initialTime = System.currentTimeMillis();
CajeroThread cajero1= new CajeroThread("Cajero 1", cliente1, initialTime);
CajeroThread cajero2= new CajeroThread("Cajero 2", cliente2, initialTime);


cajero1.start();
cajero2.start();
}
    

}
