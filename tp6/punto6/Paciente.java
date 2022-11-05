/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto6;

/**
 *
 * @author male_
 */
public class Paciente implements Runnable{
 Centro c;
 
 public Paciente (Centro c){
     this.c=c;
 }
 
 public void run(){
     c.entrarSala();
     System.out.println(Thread.currentThread().getName()+": Consegui camilla");
     this.sacarSangre();
     c.salirSala();
 }
 
 private void sacarSangre(){
     try {
         System.out.println(Thread.currentThread().getName()+": Sacandome sangre!!");
         Thread.sleep(1000);
     } catch (Exception e) {
     }
 }
}
