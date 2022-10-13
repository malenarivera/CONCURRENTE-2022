/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto1;

/**
 *
 * @author male_
 */
public class Empleado implements Runnable {
    Comedor c;
 int opcion;
 
 public Empleado (Comedor c){
     this.c=c;
     opcion= (int) ((Math.random()*3)+1);
 }
 
 public void run(){
     if(c.puedeSentarse()){
         switch (opcion){
             case 1:
                 c.liberaPuedeAtender();
                 System.out.println(Thread.currentThread().getName()+": Llame al mozo");
                 c.agarraPuedeTomar();
                 System.out.println(Thread.currentThread().getName()+": Ya tengo mi bebida :)");
             break;
             case 2:
                 c.liberaPuedeCocinar();
                 System.out.println(Thread.currentThread().getName()+": Llame al cocinero");              
                 c.agarraPuedeComer();
                 System.out.println(Thread.currentThread().getName()+": Ya tengo mi comida :)");
             break;
             case 3:
                 c.liberaPuedeAtender();
                 System.out.println(Thread.currentThread().getName()+": Ya llame al mozo, espero");
                 c.agarraPuedeTomar();
                 
                 System.out.println(Thread.currentThread().getName()+"; Tengo la bebida, Llamo al cocinero");
                 c.liberaPuedeCocinar();
                 c.agarraPuedeComer();
                 System.out.println(Thread.currentThread().getName()+": Tengo la comida y bebida, provecho");
                 
             break;
                 
         }
            this.simula();
            System.out.println(Thread.currentThread().getName()+": Me voy");
             c.liberaPuedeSentarse();   
         
             
         }else
         System.out.println(Thread.currentThread().getName()+": No puedo entrar, todo ocupado");
             
   }
 
 
 private void simula(){
     try {
         Thread.sleep(1000);
     } catch (Exception e) {
     }
 }
    
}
