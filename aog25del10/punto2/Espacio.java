/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Espacio {
      private Semaphore semOxigeno;// representa la cantidad de atomos de hidrogeno listos
    private Semaphore semHidrogeno;// representa la cantidad de atomos de oxigeno listos
    private int capacidadRecipiente;
    private Semaphore puedePonerAgua; //representa la cantidad de agua disponible para poner (rendevouz)
    private Semaphore recipienteLleno; //


    public Espacio(int capRecipientes){
        semOxigeno= new Semaphore(0);
        semHidrogeno= new Semaphore(0);
        capacidadRecipiente=capRecipientes;
        puedePonerAgua= new Semaphore(0); 
        recipienteLleno= new Semaphore(0);
    }
    public void hListo(){
        semHidrogeno.release();
    }
    public void oListo(){
        semOxigeno.release();
    }

    public void hacerAgua(){
        
        try {
            semHidrogeno.acquire(2);
            semOxigeno.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void puedePonerAgua(){
        try {
            puedePonerAgua.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void llenarRecipiente (){
        recipienteLleno.release();
    }

    public void chequearRecipienteLleno(){
        try {
            recipienteLleno.acquire(capacidadRecipiente);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void avisarRecipienteVacio(){
        puedePonerAgua.release(capacidadRecipiente);
    }


    
}
