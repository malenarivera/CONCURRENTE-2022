/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p3;

import universidad.concurrente.tp3.p3.Encargado;
import java.util.Random;

/**
 *
 * @author male_
 */
public class ClienteConcierto implements Runnable{
    private Encargado encargado;
    private int numAsiento;
    private Random r= new Random();
    
    
    public ClienteConcierto (Encargado encargado){
        this.encargado=encargado;
        numAsiento= (int)encargado.mostrarAsientosLibres().get(r.nextInt(encargado.mostrarAsientosLibres().size()));
        System.out.println(numAsiento);
    }
    
    public void run(){
        while(encargado.venderAsiento(numAsiento)==false&&!encargado.mostrarAsientosLibres().isEmpty()){
            this.simularTiempo();
            this.elegirNuevoAsiento();
            
        }
    }
    
    
    private void simularTiempo(){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
    private void elegirNuevoAsiento(){
        numAsiento= (int)encargado.mostrarAsientosLibres().get(r.nextInt(encargado.mostrarAsientosLibres().size()));
        System.out.println(numAsiento);

    }
    
}
