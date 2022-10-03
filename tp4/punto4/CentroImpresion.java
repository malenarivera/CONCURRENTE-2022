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
public class CentroImpresion {
     Impresora []impresoras;
     int cantImpresorasA;
     
     public CentroImpresion(int cantA, int cantB){
         cantImpresorasA=cantA;
         this.impresoras=new Impresora[cantA+cantB];
         this.iniciarImpresoras(cantA);
         
     }
     
     public int imprimirDocumento(char tipoDocumento){
         return this.buscarImpresoraTipo(tipoDocumento);
     }
     
     private int buscarImpresoraTipo(char tipoDoc){
         int cont=0, impresoraQueLeToco=0;
         boolean encontro=false;
         if(tipoDoc=='A')
           impresoraQueLeToco=this.buscarImpresoraA(tipoDoc);
         else{
             if(tipoDoc=='B')
                impresoraQueLeToco=this.buscarImpresoraB(tipoDoc);
             //si es un documento X busco cualquier impresora libre
             else{
                 while(cont<impresoras.length){
                     if(impresoras[cont].impresoraLibre()){
                         System.out.println(Thread.currentThread().getName()+" Imprimiendo en la impresora "+impresoras[cont].getTipo()+cont+ " un documento tipo "+tipoDoc);
                         impresoraQueLeToco=cont;
                         encontro=true;
                         cont=impresoras.length+2;
                     }else
                         cont++;
                 }
                 
                 //si ninguna esta libre espero en alguna random
                 if(encontro==false){
                     impresoraQueLeToco=(int) (Math.random()*(impresoras.length));
                     System.out.println(Thread.currentThread().getName()+": Todas las impresoras llenas, espero por la impresora "+impresoras[impresoraQueLeToco].getTipo()+impresoraQueLeToco+ " para imprimir un documento tipo "+tipoDoc);
                     impresoras[impresoraQueLeToco].ocuparImpresora();
                 }
             }
         
     }
         return impresoraQueLeToco;
     }
     
   
     
     public void liberarImpresora(int numeroImpresora){
         System.out.println(Thread.currentThread().getName()+": Libero la impresora "+impresoras[numeroImpresora].getTipo()+numeroImpresora);
       impresoras[numeroImpresora].desocuparImpresora();
     }
     
     
     
     
     private void iniciarImpresoras(int cant){
             for (int i = 0; i < cant; i++) {
                 impresoras[i]= new Impresora ('A');
             }
             for (int i = cant; i < impresoras.length; i++) {
                 impresoras[i]= new Impresora('B');
             
        }
     }
     
     private int buscarImpresoraA(char tipoDoc){
         int impresoraQueLeToco=0,cont=0;
         boolean encontro=false;
         //por cada impresora tipo A me fijo si hay alguna libre
         while(cont<cantImpresorasA){
                 if(impresoras[cont].impresoraLibre()){
                     System.out.println(Thread.currentThread().getName()+" Imprimiendo en la impresora "+impresoras[cont].getTipo()+cont+ " un documento tipo "+tipoDoc);
                     impresoraQueLeToco=cont;
                     encontro=true;
                     cont=cantImpresorasA+1;
                 }else
                     cont++;
             }
             //si no encuentra ninguna entonces espera en una impresora tipo A random
             if(encontro==false){
                 impresoraQueLeToco= (int) (Math.random()* (cantImpresorasA-1));
                 System.out.println(Thread.currentThread().getName()+": Todas las impresoras A llenas, espero por la impresora "+impresoras[impresoraQueLeToco].getTipo()+impresoraQueLeToco+ " para imprimir un documento tipo "+tipoDoc);
                 impresoras[impresoraQueLeToco].ocuparImpresora();
             }
             return impresoraQueLeToco;
     }
     
     private int buscarImpresoraB(char tipoDoc){
         int impresoraQueLeToco=0, cont;
         boolean encontro=false;
           cont=cantImpresorasA;
           //por cada impresora tipo B me fijo si hay alguna libre
                 while(cont<impresoras.length){
                     if(impresoras[cont].impresoraLibre()){
                         System.out.println(Thread.currentThread().getName()+" Imprimiendo en la impresora "+impresoras[cont].getTipo()+cont+ " un documento tipo "+tipoDoc);
                         impresoraQueLeToco=cont;
                         encontro=true;
                         cont=impresoras.length+2;
                     }else
                         cont++;
                 }
                 //si ninguna esta libre entonces espero en alguna impresora tipo B random
                 if(encontro==false){
                     impresoraQueLeToco= (int) (Math.random()* (impresoras.length -cantImpresorasA)) + cantImpresorasA;
                     System.out.println(Thread.currentThread().getName()+": Todas las impresoras B llenas, espero por la impresora "+impresoras[impresoraQueLeToco].getTipo()+impresoraQueLeToco+ " para imprimir un documento tipo "+tipoDoc);
                     impresoras[impresoraQueLeToco].ocuparImpresora();
                 }
                 
        return impresoraQueLeToco;
     }
}



     

