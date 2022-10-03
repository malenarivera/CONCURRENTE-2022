/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p3;

import universidad.concurrente.tp3.p3.SalaConcierto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author male_
 */
public class Encargado  {
    private SalaConcierto sala;
    
    
    public Encargado (SalaConcierto sala){
        this.sala=sala;
    }
    
    
    public synchronized boolean venderAsiento(int numAsiento){
        boolean seVendio=false;
        if(sala.salaLlena()==false){
            if(sala.comprarAsiento(numAsiento, Thread.currentThread().getName())==true){
                System.out.println("Le vendi el asiento "+numAsiento+ " al cliente "+Thread.currentThread().getName());
                seVendio=true;
        }
        }
        
        return seVendio;
    }
    
    
    public synchronized ArrayList mostrarAsientosLibres(){
        return sala.asientosLibres();
    }
    
}

