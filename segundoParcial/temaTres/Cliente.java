/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.segundoParcial.temaTres;

/**
 *
 * @author male_
 */
public class Cliente implements Runnable{
    private Carro c;
    
    public Cliente (Carro c){
        this.c=c;
    }
    
    public void run(){
        //MIENTRAS LA ATRACCION ESTA ABIERTA SUBEN, SINO... NO SUBEN JUA JUA
        while(c.getEstaAbierta()){
            c.subirmeAlCarro();
            System.out.println(Thread.currentThread().getName()+": Me subi al carro");
            c.intertarBajarme();
            c.bajarmeAtraccion();
            System.out.println(Thread.currentThread().getName()+": Me bajé del carro");
            this.simularTiempo();
        }
    }
    
    private void simularTiempo(){
        //IGUAL ESTO ES MALISIMO PERO WENO ASI LO DISE EL ENUNCIAO
        try {
            System.out.println(Thread.currentThread().getName()+": Doy vueltas por el parqueee!!");
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
    
}
