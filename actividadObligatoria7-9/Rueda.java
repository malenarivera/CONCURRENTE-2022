package universidad.concurrente.tp3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author male_
 */
public class Rueda {
    private boolean noEnUso=true;
    
     public synchronized boolean ocupado(){
           if(noEnUso){
               this.usar();
           }
           return noEnUso;
       }
    
   
    
    public synchronized void realizarActividad(){
        System.out.println(Thread.currentThread().getName()+ " esta jugando con la RUEDA");
        try{
            Thread.sleep(1000);
             System.out.println(Thread.currentThread().getName()+ " termino de jugar con la RUEDA ");
        }catch(InterruptedException e){
            
        }
    }
    
    public synchronized void usar(){
        noEnUso=false;
    }
    
    public synchronized void dejoDeUsar(){
        System.out.println(Thread.currentThread().getName()+" termino de usar la Rueda");
        noEnUso=true;
    }
}
