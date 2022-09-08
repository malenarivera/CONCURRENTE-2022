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
public class Hamster implements Runnable {
//    private Jaula j;
//    
//    public Hamster(Jaula j){
//        this.j=j;
//    }
//
//    @Override
//    public void run() {
//        j.usarHamaca();
//        j.usarPlato();
//        j.usarRueda();
//     }
    Rueda r= new Rueda();
    Comida c= new Comida();
    Hamaca h= new Hamaca();
    
    public Hamster(Rueda r, Hamaca h, Comida c){
        this.r=r;
        this.h=h;
        this.c=c;
        
    }
    
    
    public void run(){
        while(!h.ocupado()){
           this.simularTiempo();
           h.dejoDeUsar();
        }
        
        while(!r.ocupado()){
            this.simularTiempo();
            r.dejoDeUsar();
        }
        while(!c.ocupado()){
            this.simularTiempo();
            c.dejoDeUsar();
        }
    }
    
 private void simularTiempo(){
     try {
          Thread.sleep(1000);
     } catch (Exception e) {
     }
 }
    
    
}
