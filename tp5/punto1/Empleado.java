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
     //puede sentarse es un tryacquire
     if(c.puedeSentarse()){
         switch (opcion){
             case 1:
                 //los que solo piden bebida
                 System.out.println(Thread.currentThread().getName()+": Llamo al mozo");
                 c.liberaPuedeAtender();
                 c.agarraPuedeTomar();
                 System.out.println(Thread.currentThread().getName()+": Ya tengo mi bebida :)");
             break;
             case 2:
                 //los que solo piden comida
                 System.out.println(Thread.currentThread().getName()+": Llamo al cocinero");
                 c.liberaPuedeCocinar();
                 c.agarraPuedeComer();
                 System.out.println(Thread.currentThread().getName()+": Ya tengo mi comida :)");
             break;
             case 3:
                 //piden las dos cosas
                 //estos primeros llaman al mozo y dps al cocinero
                 System.out.println(Thread.currentThread().getName()+": Ya llamo al mozo, espera");
                 c.liberaPuedeAtender();
                 c.agarraPuedeTomar();
                 
                 System.out.println(Thread.currentThread().getName()+"; Tengo la bebida, Llamo al cocinero");
                 c.liberaPuedeCocinar();
                 c.agarraPuedeComer();
                 System.out.println(Thread.currentThread().getName()+": Tengo la comida y bebida, provecho (?");
                 
             break;
                 
         }
         //todos simulan el tiempo de beber / comer / beber-comer
            this.simula();
            System.out.println(Thread.currentThread().getName()+": Me voy");
             c.liberaPuedeSentarse();   
         
             
         }else
         //si no se puede sentar se va :(
         System.out.println(Thread.currentThread().getName()+": No puedo entrar, todo ocupado");
             
   }
 
 
 private void simula(){
     try {
         Thread.sleep(1000);
     } catch (Exception e) {
     }
 }
    
}
