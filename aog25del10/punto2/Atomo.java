/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto2;

import java.util.Random;

/**
 *
 * @author  GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Atomo implements Runnable{
    private Espacio e;
    private char tipo;
    private boolean hacerAgua;


    public Atomo (Espacio e, char tipo, boolean hacerAgua){
        this.e=e;
        this.tipo=tipo;
        this.hacerAgua=hacerAgua;
    }

    public void run (){
        this.vagarPorElEspacio();
        if (tipo=='O'){
            e.oListo();
            System.out.println("Oxigeno LISTO");

        }
        else{
            e.hListo();
            System.out.println("Hidrogeno LISTO");
        }
        
    
        if (hacerAgua){
            e.puedePonerAgua();
            e.hacerAgua();
            
            System.out.println("Se juntan para crear agua........");
            
            e.llenarRecipiente();
            System.out.println("Agua puesta en el recipiente");
        }

    }

    public void vagarPorElEspacio(){
        Random r= new Random();
      
        try {
            Thread.sleep( r.nextInt(100));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}