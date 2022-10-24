/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author male_
 */
public class Reloj {
    private int trabajadorActual;//puntero indica la pos en la que debe hacer el release y el 2 el acquire
    private Semaphore [] semTrabajadores;
    private int cantTrabajadores;
    private Semaphore semDormir;



    public Reloj (int cantTrabajadores){
        this.cantTrabajadores=cantTrabajadores;
        semTrabajadores= new Semaphore [cantTrabajadores];
        for(int i=0;i<semTrabajadores.length;i++) {
            semTrabajadores[i]= new Semaphore(0);
        }
        semDormir= new Semaphore(0);
    }

    public void despertarPrimerHilo(){
        semTrabajadores[0].release();
        trabajadorActual=0;
       
    }
    
    public void despertarPana(){
        if (trabajadorActual<(cantTrabajadores-1)){
            //levanto a mi pana
            trabajadorActual++;
            semTrabajadores[trabajadorActual].release();
        }
      
    }
    public void despertarme(int nroTrabajador){
        try {
            semTrabajadores[nroTrabajador].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void esperarZZZ(){
        try {
            semDormir.acquire(cantTrabajadores);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void aMimir(){
        semDormir.release();
    }
}