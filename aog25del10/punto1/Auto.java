/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto1;

/**
 *
 * @author @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Auto implements Runnable{
    private RecursoCompartido rc;

public Auto(RecursoCompartido rc){
    this.rc=rc;
}

public void run(){
    this.simularViaje();
    rc.agarroPermiso();
    System.out.println(Thread.currentThread().getName()+": Me subi al transbordador");
    rc.avisoLlegada();
    rc.bajarse();
    System.out.println(Thread.currentThread().getName()+": Me baje del transbordador");
    rc.avisoSalida();
    
}

private void simularViaje(){
    try {
        System.out.println(Thread.currentThread().getName()+": Comienzo viaje al lado oeste");
        Thread.sleep(1000);
    } catch (Exception e) {
    }
}
}
