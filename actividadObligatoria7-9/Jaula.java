/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3;

/**
 *
 * @author male_
 */
public class Jaula {
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private Object plato;
    private Object hamaca;
    private Object rueda;
    
    public Jaula(){
        plato= new Object();
        hamaca= new Object();
        rueda= new Object();
    }
    
    
    public void usarHamaca(){
        synchronized(hamaca){
            System.out.println(ANSI_CYAN_BACKGROUND+Thread.currentThread().getName()+" empieza a usar la HAMACA");
            this.usar();
            System.out.println(ANSI_CYAN_BACKGROUND+Thread.currentThread().getName()+" termino de usar la HAMACA");
        }
    }
    
     public void usarPlato(){
        synchronized(plato){
            System.out.println(ANSI_YELLOW_BACKGROUND+Thread.currentThread().getName()+" EMPIEZA a usar el PLATO");
            this.usar();
            System.out.println(ANSI_YELLOW_BACKGROUND+Thread.currentThread().getName()+" TERMINA de usar el PLATO");
        }
    }
     
      public void usarRueda(){
        synchronized(rueda){
            System.out.println(Thread.currentThread().getName()+" EMPIEZA a usar la RUEDA");
            this.usar();
            System.out.println(Thread.currentThread().getName()+" TERMINA de usar la RUEDA");
        }
    }
      
      private void usar(){
          try {
              Thread.sleep(1000);
          } catch (Exception e) {
          }
}
}
