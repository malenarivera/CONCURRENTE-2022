/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p6;

/**
 *
 * @author male_
 */
public class Sumadores implements Runnable{
 
     private int []a;
    private int inicioSuma,finSuma;
    private Suma sumaCompartida;
    
    public void run (){
        int sumaParcial=0;
        for (int i=inicioSuma;i<finSuma;i++){
            sumaParcial+=a[i];
        }
        
        sumaCompartida.sumar(sumaParcial);
        
        
        
    }

    public Sumadores(int[] a, int inicioSuma, int finSuma, Suma sumaCompartida) {
        this.a = a;
        this.inicioSuma = inicioSuma;
        this.finSuma = finSuma;
        this.sumaCompartida = sumaCompartida;
    }
           

}
