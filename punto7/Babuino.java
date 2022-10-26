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
    private Puente p;
    public Babuino (Puente p){
        this.p=p;
    }
    public void run (){
        Random r= new Random();
        if (r.nextInt(2)==0){
            System.out.println(Thread.currentThread().getName() + " QUIERE PASAR DE LA IZQ");
            p.pasar('I');
        }
        else{
            System.out.println(Thread.currentThread().getName() + " QUIERE PASAR DE LA DER");
            p.pasar('D');
        }
        System.out.println(Thread.currentThread().getName()+ ": PASANDOOOOOOO");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": Me fui");
        p.irse();


    }

}
    

