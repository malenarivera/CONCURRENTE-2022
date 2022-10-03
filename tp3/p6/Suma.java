/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p6;

/**
 *
 * @author male_
 */
public class Suma {
        private int valor;
    
    public Suma (){
        valor=0;
    }
    public synchronized  void sumar (int cant){
        valor+=cant;
    }
    public  synchronized int getSuma (){
        return valor;
    }
}
