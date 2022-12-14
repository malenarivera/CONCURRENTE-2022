/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto3;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class HiloTrabajador implements Runnable {
    private Reloj r;
    private int nroTrabajador;

    public HiloTrabajador (Reloj r, int nroTrabajador){
        this.r=r;
        this.nroTrabajador=nroTrabajador;
    }

    public void run (){
        
        while (true){
            r.despertarme(nroTrabajador);
            System.out.println(Thread.currentThread().getName()+ ": Me levanté");
            System.out.println(Thread.currentThread().getName()+ ": Levanto a mi panita");
            r.despertarPana(nroTrabajador);
            if (this.esHoraTrabajo()){
               System.out.println(Thread.currentThread().getName()+ ": es mi hora de trabajo");
               this.simularTrabajo();
            }
            System.out.println(Thread.currentThread().getName()+ ": Me vuelvo a dormir");
            r.aMimir();
        }
    }


    private boolean esHoraTrabajo(){
        //para simular el caso de que sea su hora de trabajo
        return ((int)(Math.random()*3)+1==2);
    }
    
    
    private void simularTrabajo(){
                try {
                    System.out.println(Thread.currentThread().getName()+": Trabajando");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }

    
}
