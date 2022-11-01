/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto4;

/**
 *
 * @author male_
 */
public class Persona implements Runnable{
    Observatorio o;
   private int sillaDeRuedas;
    
    public Persona(Observatorio o){
        this.o=o;
        sillaDeRuedas= (int) (Math.random()*5);
    }
    
    public void run(){
        if(sillaDeRuedas==4){
            o.entrarSalaSillaRuedas();
            System.out.println(Thread.currentThread().getName()+": Entro a la sala en silla de ruedas");
            this.simularTiempo();
            o.salirSalaSilla();
        }else{
            o.entrarSala();
            System.out.println(Thread.currentThread().getName()+": Entro a la sala");
            this.simularTiempo();
            o.salirSala();
    }
        
    
}
    
private void simularTiempo(){
    try {
        Thread.sleep(1000);
    } catch (Exception e) {
    }
}
}
