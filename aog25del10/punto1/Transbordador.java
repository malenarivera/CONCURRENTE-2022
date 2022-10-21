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
public class Transbordador implements Runnable {
 private RecursoCompartido rc;
 
 public Transbordador (RecursoCompartido rc){
     this.rc=rc;
 }
 
 public void run(){
     while(true){
         rc.iniciarViaje();
         System.out.println("Transbordador: Comenzando viaje");
         this.simulaViaje();
         System.out.println("Transbordador: LLegue a destino, pueden bajar los autos");
         rc.llegaADestino();
         rc.iniciarViaje();
         System.out.println("Transbordador: ya no hay mas autos, vuelvo vacio");
         this.simulaViaje();
         System.out.println("Transbordador: ya pueden subir");
         rc.terminoVuelta();
     }
 }
 
 private void simulaViaje(){
     try {
         System.out.println("Viajando");
         Thread.sleep(1000);
     } catch (Exception e) {
     }
 }
 
}
