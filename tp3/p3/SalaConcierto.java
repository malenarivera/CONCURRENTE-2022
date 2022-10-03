/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author male_
 */
public class SalaConcierto {
    private Asiento [] asientos;
    private ArrayList asientosDisponibles= new ArrayList();
    
    public SalaConcierto(int cantAsientos){
        asientos= new Asiento [cantAsientos];
        for (int i = 0; i < asientos.length; i++) {
            asientos[i]= new Asiento();
            asientosDisponibles.add(asientos[i]);
        }
    }
    
    public boolean comprarAsiento(int a, String nombreCliente){
        boolean sePudo;
            if(asientos[a].getOcupacion()==false){
                asientos[a].setOcupacion();
                System.out.println("El cliente "+nombreCliente+ " compro el asiento "+a);
                sePudo=true;
            }
            else
                sePudo=false;
            return sePudo;
    }
    
    
    public  boolean salaLlena(){
        return asientosDisponibles.isEmpty();
    }
    
    public ArrayList asientosLibres(){
       ArrayList a= new ArrayList();
        for (int i = 0; i < asientos.length; i++) {
            if(asientos[i].getOcupacion()==false){
                a.add(i);
            }
        }
        return a;
    }
    
}
