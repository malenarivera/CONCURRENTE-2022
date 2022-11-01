/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author male_
 */
public class GestionTrafico {
   private int cantCochesCruzandoNorte;
   private int cantCochesCruzaronDelNorte;
   private int cantCochesEsperandoSur;
   private int cantCochesEsperandoNorte;
   private int cantCochesCruzaronDelSur;
    private int cantCochesCruzandoSur;
    
    public GestionTrafico(){
        cantCochesCruzandoNorte=0;
        cantCochesCruzandoSur=0;
        cantCochesEsperandoNorte=0;
        cantCochesEsperandoSur=0;
        cantCochesCruzaronDelNorte=0;
        cantCochesCruzaronDelSur=0;
    }
    
 
    public synchronized void entrarCocheSur(){
        while(cantCochesCruzandoNorte>0||(cantCochesCruzaronDelSur>=10&&cantCochesEsperandoNorte>0)){
            System.out.println(Thread.currentThread().getName()+": Debe esperar");
            cantCochesEsperandoSur++;
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        System.out.println(Thread.currentThread().getName()+": Cruzando desde el sur");
       //porque sino toma valores negativos y f
        if(cantCochesEsperandoSur>0){
            cantCochesCruzaronDelNorte=0;
            cantCochesEsperandoSur--;
        }
        cantCochesCruzandoSur++;
        cantCochesCruzaronDelSur++;
    }
    
    public synchronized void salirCocheSur(){
        System.out.println(Thread.currentThread().getName()+": Salio del punte desde el sur");
        cantCochesCruzandoSur--;
        if(cantCochesCruzandoSur==0){
            this.notifyAll();
    }
    }
    
    public synchronized void entrarCocheNorte(){
        while(cantCochesCruzandoSur>0||(cantCochesCruzaronDelNorte>=10&&cantCochesEsperandoSur>0)){
            System.out.println(Thread.currentThread().getName()+": Debe esperar");
            cantCochesEsperandoNorte++;
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        System.out.println(Thread.currentThread().getName()+": Cruzando desde el norte");
        //sino toma valores negativos y f
        if(cantCochesEsperandoNorte>0){
            cantCochesCruzaronDelSur=0;
            cantCochesEsperandoNorte--;
        }
        cantCochesCruzandoNorte++;
        cantCochesCruzaronDelNorte++;
    }
    
    public synchronized void salirCocheNorte(){
        System.out.println(Thread.currentThread().getName()+": Salio del punte desde el norte");
        cantCochesCruzandoNorte--;
        if(cantCochesCruzandoNorte==0){
             this.notifyAll();
    }
    }
    
}
