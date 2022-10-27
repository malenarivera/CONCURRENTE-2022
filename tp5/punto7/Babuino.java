/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto7;

import java.util.Random;

/**
 *
 * @author male_
 */
public class Babuino implements Runnable{
    
      private char lado;
    private Cuerda c;

    public Babuino (char lado, Cuerda c){
        this.lado= lado;
        this.c=c;
    }

    public void run (){
        c.setearPrioridadBabuino(lado);
        c.entrar(lado);
        this.pasando();
        c.irse(lado);




    }
    public void pasando (){
        try {
            System.out.println(Thread.currentThread().getName()+" PASANDOOOO");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}


    

