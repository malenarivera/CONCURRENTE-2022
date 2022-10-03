/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p2;

/**
 *
 * @author male_
 */
public class Vida {
    //HOOOOOLA MALEEEEE
    private int vida=10;
    
    public synchronized int getVida(){
        return vida;
    }
    
   public synchronized void  setVida(int num){
       //le entra un positivo si es curandero y un negativo si es orco, y como + * - es -, jua jua
       vida=vida+num;
   }
   
}
