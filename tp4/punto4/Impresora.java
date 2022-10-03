/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class Impresora {
    private char tipo;
    private Semaphore mutex;
    
    
    public Impresora(char tipo){
        this.tipo=tipo;
        mutex= new Semaphore(1);
    }
    
public char getTipo(){
    return this.tipo;
}    

   public void ocuparImpresora(){
       try {
           mutex.acquire();
       } catch (Exception e) {
       }
   }
    
    
   public boolean impresoraLibre(){
      return mutex.tryAcquire();
   }
   
   public void desocuparImpresora(){
       mutex.release();
   }
}
