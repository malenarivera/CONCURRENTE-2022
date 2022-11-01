/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto3;

/**
 *
 * @author male_
 */
public class Soldado implements Runnable {
    Comedor c;
   private int leToco; //para simular si le toco gaseosa o awa
    private int quierePostre; //para simular si se sirve postre o no

public Soldado(Comedor c){
    this.c=c;
    leToco= (int)(Math.random()*5);
    quierePostre= (int) (Math.random()*5);
    
}

  public void run(){
      c.entrarMostrador();
      System.out.println(Thread.currentThread().getName()+": Se sirvio comida");
      this.simularTiempo();
      System.out.println(Thread.currentThread().getName()+": Termino de servirse la comida");
      c.abandonarMostrador();
      if(leToco==3){
          System.out.println(Thread.currentThread().getName()+": Agarro gaseosa");
          c.abrirBotella();
          System.out.println(Thread.currentThread().getName()+": Abriendo la botella");
          this.simularTiempo();
          System.out.println(Thread.currentThread().getName()+": Termino de abrir la botella");
          c.terminarAbrirBotella();
      }else
          System.out.println(Thread.currentThread().getName()+": Agarro agua");
      if(quierePostre==2){
          System.out.println(Thread.currentThread().getName()+": Quiere postre");
          c.servirsePostre();
          System.out.println(Thread.currentThread().getName()+": Sirviendose el postreee");
          this.simularTiempo();
          System.out.println(Thread.currentThread().getName()+": termino de servirse el postre");
          c.terminoPostre();
      }else
          System.out.println(Thread.currentThread().getName()+": NO queria postre");
  }
  
  
  private void simularTiempo(){
      try {
          Thread.sleep(1000);
      } catch (Exception e) {
      }
  }
  
  



}
