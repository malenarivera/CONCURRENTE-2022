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
public class Hamaca {
    private boolean noEnUso=true;
    
       public synchronized boolean ocupado(){
           if(noEnUso){
               this.usar();
           }
           return noEnUso;
       }
    
    public synchronized void realizarActividad(){
        System.out.println(Thread.currentThread().getName()+ " esta descansando en la HAMACA");
        try{
            Thread.sleep(1000);
             System.out.println(Thread.currentThread().getName()+ " termino de descansar en la HAMACA");
        }catch(InterruptedException e){
            
        }
    }
    
     public synchronized void usar(){
        noEnUso=false;
    }
    
    public synchronized void dejoDeUsar(){
        System.out.println(Thread.currentThread().getName()+" termino de descansar en la hamaca");
        noEnUso=true;
    }
    
}
